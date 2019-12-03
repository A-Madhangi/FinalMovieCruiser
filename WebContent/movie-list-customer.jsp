
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!Doctype html>
<html>
<head>
<title>movie list customer</title>
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
	<h1 class="body_h1">Movies</h1>
	
	<c:if test="${addFavouriteStatus}">
	<div class="alert">
      
        <center><strong>MovieList added to favourites successfully</strong></center>
	</div>	
	</c:if>
	
	
	
	
	<table style="width:100%;" id="books">
		<tr>
			<th class="td_name">Title</th>
			<th class="td_delivery">Box Office</th>
			
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
			<c:forEach var="item" items="${customerMovieList}">
		<tr>
			<td class="td_name">${item.title}</td>
			<td class="td_delivery">${item.boxOffice }</td>
			
			<td>${item.genre}</td>
			<td>${item.hasTeaser ? 'Yes' : 'No' }</td>
			<td>
			<a href="AddToFavouriteServlet?movieListId=${item.id}">Add to Favorite</a>
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