<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.cognizant.moviecruiser.model.MovieList"  %>
<!Doctype html>
<head>
<title>Movie list admin</title>
<link rel="stylesheet" href="styles/style.css">
</head>
<body>
<header class="header container-fluid">
     <h2 class="header-itemleft">Movie Cruiser</h2>
     <img class="img_h" src="images/m_logo.jpg">
     <a class="header-itemright" href="ShowMovieListAdminServlet" style="margin:15px;">Movies </a>
</header>


<section class="body-main" style="overflow-x:auto;">
	<h1 class="body_h1">Movies</h1>
	<table style="width:100%;" id="books">
		<tr>
			<th class="td_name">Title</th>
			<th class="td_price">Box Office</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
	    <c:forEach var="item" items="${adminMovieList}">
		<tr>
			<td class="td_name">${item.title}</td>
			<td class="td_price"><fmt:formatNumber type="currency" value="${item.boxOffice}"/></td>
			<td>${item.active ? 'Yes' : 'No'  }</td>
			<td><fmt:formatDate pattern="dd/MM/yyyy"  value="${item.date}"/></td>
			<td>${item.genre}</td>
			<td>${item.hasTeaser ? 'Yes' : 'No' }</td>
			<td>
			<a href="ShowEditMovieListServlet?movieListId=${item.id}">Edit</a>
			</td>
		</tr>
		</c:forEach>
		
</table>
</section>
<footer class="footer container-fluid">
	<p>&nbsp;&nbsp;Copyright &copy; 2019</p>
</footer>


</body>
</html>
