<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!Doctype html>
<html>
<head>
<title>Favorites</title>
<link rel="stylesheet" href="styles/style.css">
</head>
<body>	
<header class="header container-fluid">
	<h2 class="header-itemleft">Movie Cruiser</h2>
	<img src="images/m_logo.jpg" class="img_h">

	<a class="header-itemright" href="ShowMovieListCustomerServlet" style="margin:15px;">Movies</a>	
	<a class="header-itemright" href="ShowFavouriteServlet" style="margin:15px;">Favorites</a>																																																																																									
</header>	
<section class="body-main" style="overflow-x:auto;">
	<h1 class="body_h1">Favorites</h1>
	
	<c:if test="${removeFavouriteStatus}">
	 <p class="block_item"><b>MovieList removed from Favourites successfully</b></p>
	</c:if>
	
	
	
	
	<table style="width:100%;" id="books">
		<tr>
			<th class="td_name">Title</th>
			<th class="td_delivery">Box Office</th>
			
			<th>Genre</th>
			
		</tr>
		<c:set var="count" value="${0}"></c:set>
		<c:forEach var="item" items="${favouriteMovieList}">
		<tr>
			<td class="td_name">${item.title}</td>
			<td class="td_delivery">${item.boxOffice}</td>
			
			<td>${item.genre}</td>
			<c:set var="count" value="${count+1}"></c:set>
			<td>
			<a href="RemoveFavouriteServlet?movieListId=${item.id}">Delete</a>
			</td>
		</tr>
		</c:forEach>
		<tr>
		<td></td>
		<td>Count:</td>
		<td><c:out value="${count}"/>
		</td></tr>
		
		
		</table>
</section>
			
<footer class="footer container-fluid">
	<p>&nbsp;&nbsp;Copyright &copy; 2019</p>
</footer>






  		
</body>
</html>
        