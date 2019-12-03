<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.cognizant.moviecruiser.model.MovieList" %>


<!Doctype html>
<html>
<head>
<title>Edit Movie</title>
<link rel="stylesheet" href="styles/style.css">
<link rel="stylesheet" href="styles/edit-style.css">

<script type="text/javascript" src="js/edit-menu.js">

</script>
</head>
<body>
<header class="header container-fluid">
	<h2 class="header-itemleft">Movie Cruiser</h2>
	<img src="images/m_logo.jpg" class="img_h">
	<a class="header-itemright" href="ShowMovieListAdminServlet" style="margin:15px;">Movies</a>	
																																																																																									
</header>	

<section class="body-main" style="overflow-x:auto;">
     
  	<h1 class="body_h1">Edit Movie</h1>
  	
  	 <c:set var="dob" scope="request" value="${movieList.date}"/>
    <c:set var="genres" value="Science Fiction,SuperHero,Romance,Comedy,Adventure,Thriller" scope="application"/>
    <c:set var="selected"  value="${movieList.genre }" scope="application"/>
  	
  	
  	
  	
	<form name="editMenuForm" action="EditMovieListServlet" method="post" onsubmit="return validateMenuItem()">
        <table style="width:100%" id="">
	<tr><th colspan="4"><label for="mname">Title</label><th></tr>
	<tr><td colspan="4"><input type="text"  style="width:88%; height:30px;" name="mname" value="<c:out value="${movieList.title}"/>"></td></tr>
	<tr>
	<th><label for="price">Gross</label></th>
	<th><label for="active">Active</label></th>
	<th><label for="launch">Date of Launch</label></th>
	<th><label for="category">Genre</label></th>
	</tr>

	<tr>
	<td><input type="text" name="boxoffice" id="price"  value="<c:out value="${movieList.boxOffice}"/>"></td>
	
	 <c:choose>
     <c:when test="${movieList.active}">
	<td><input type="radio" name="available" value="yes" id="active" checked>Yes
	<input type="radio" name="available" value="no" id="active" >No
	</td>
	</c:when>
    <c:otherwise >
   
	<td>
	<input type="radio" name="available" value="yes" id="active" >Yes
	<input type="radio" name="available" value="no" id="active" checked>No
	</td>
	</c:otherwise>
    </c:choose>
	
	<td><input type="date" name="launch" id="launch" value=<fmt:formatDate pattern="dd/MM/yyyy" value="${dob}" />></td>
	
	<td>
	<select name="genre" id="genre">
	<option value="${movieList.genre}" selected>${selected}</option>
	<c:forEach items="${genres}" var="genre">
    <c:if test="${genre!=selected}">
    <option value="${genre}">${genre}</option>
	 </c:if>
	 </c:forEach> 
	</select></td>
	</tr>

	<tr>
	<td><input type="checkbox" name="freedelivery" value="" <c:if test="${movieList.hasTeaser}"> checked="checked" </c:if>>
	<label>Has Teaser</label><td>
	</tr>

	<tr>
	<td><button type="submit" name="save" style="width:50%" value="Save">Save</button></td>
	</tr>


 	</table>
 	<input type="hidden" id="movielistid" name="movielistid" value="${movieList.id }">
        </form>
</section>

<footer class="footer container-fluid">
	<p>&nbsp;&nbsp;Copyright &copy; 2019</p>
</footer>
</body>
</html>