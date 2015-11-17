<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>CS3 Coffee Shop Locator</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="css/styles.css" rel="stylesheet">
	</head>
	<body>
<div class="navbar-wrapper">
  <div class="container">
    <div class="navbar navbar-inverse navbar-static-top">
      
        <div class="navbar-header">
    	    <a class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
    	      <span class="icon-bar"></span>
    	      <span class="icon-bar"></span>
    	      <span class="icon-bar"></span>
    	    </a>
          <a class="navbar-brand" href="#">CS320 Coffee Shop Locator</a>
        </div>
        

    </div>
  </div><!-- /container -->
</div><!-- /navbar wrapper -->


<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="item active">
      <img src="images/1.jpg" class="img-responsive">
      <div class="container">
        <div class="carousel-caption">
          <h1>CS320 Coffee Shop Locator</h1>
          <p>You can search for your favorite coffee shop by city name.</p>          
        </div>
      </div>
    </div>
    <div class="item">
      <img src="images/2.jpg" class="img-responsive">
      <div class="container">
        <div class="carousel-caption">
          <h1>Search by Zipcode</h1>
          <p>Enter a zipcode to find all coffee shops within the specified area.</p>          
        </div>
      </div>
    </div>
    <div class="item">
      <img src="images/3.jpg" class="img-responsive">
      <div class="container">
        <div class="carousel-caption">
          <h1>Not sure where you are?</h1>
          <p>We can geolocate you using your device's built-in gps.  Give it a try!</p>          
        </div>
      </div>
    </div>
  </div>
  <!-- Controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="icon-prev"></span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="icon-next"></span>
  </a>  
</div>
   <!-- Controls -->

<form action="CoffeeSearch" method="get"><div class="container marketing" align="center">
<div>
 <h2>City Name</h2>
      <p>Search by city name.  Not sure how to spell a city? Try your best and we'll find the closest cities that sound like your search entry.</p>
      <p><a class="btn btn-default" href="CoffeeSearch">Back to Home</a></p>
      <p><input type="text" name="name"><input type="submit" value="search"> </p>
      <input type="hidden" value="City" name="type" />
    </div>
    <%--Displaying CoffeeShops based on City Search --%>
    <div>
  
    </div>
</div></form>


 
	<!-- script references -->
		<script src="js/jquery-2.1.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/scripts.js"></script>


<c:if test="${ !empty MVCCoffeeSearch }">
	<div align="center">
	<h2>Search Results</h2>
				<table>
				<tr>
				<th style="width:185px;">
				CoffeeShop Name
				</th>
				<th style="width:185px;">
				City & Zipcode
				</th>
				<th>
				Complete Detail
				</th>
				</tr>
	
	<c:forEach items="${ MVCCoffeeSearch }" var="books">
	<tr>
				<td>
				<p>${ books.getName() }</p>
				</td>
				<td>
			<p>${ books.getCity() }</p>
			<p> ${ books.getZipcode() }</p>
				</td>
				<td>

<c:url value="CoffeeShopDetails" var="displayURL">
  <c:param name="id"   value="${books.getId()}" />
     <c:param name="lat" value="${books.getLati()}"/>
       <c:param name="lon" value="${books.getLongi()}"/>
  
</c:url>


				<a href='<c:out value="${displayURL}" />'>Details</a>
				
				</td>
				</tr>
	
			
		
	</c:forEach>
	</table>
	</div>
	
</c:if>
</body>
</html>