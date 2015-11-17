<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:useBean class="cs320.mvc.CoffeeShopBean" id="bg" /> 
<jsp:setProperty name="bg" property="*" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Coffee Shop Details</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="css/styles.css" rel="stylesheet">
		
		<!-- maps script -->
		<script src="http://maps.google.com/maps?file=api&v=2&key=ABQIAAAA496CbrflCxvduLD30wNsqhQq3tWW1UGy0rG7B4F3xzgSR63hWxSoz3WEdQlXbSF2-qEhMm4zqDCfRg" type="text/javascript"></script>
<script type="text/javascript">
function load(){
	var searchlat='<%= (String) request.getParameter("lat") %>';
	var searchlon='<%= (String) request.getParameter("lon") %>';
if (GBrowserIsCompatible()) {
var map = new GMap2(document.getElementById("map"));
map.setCenter(new GLatLng(searchlat,searchlon), 13);
mapTypeId: google.maps.MapTypeId.ROADMAP;

var point = new GLatLng(searchlat,searchlon);
map.setCenter(point, 15);
var marker = new GMarker(point);
map.addOverlay(marker);
return searchlat;
}
}

</script>
		
		
	</head>
	<body onload="load()" onunload="GUnload()">
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
<!-- /.Controls -->
      <p><a class="btn btn-default" href="CoffeeSearch">Back to Home</a></p>

<div align="left">
<table>
<tr>
<td>
<c:choose>
        <c:when test="${empty csbeans}">
            <h3>There are currently no answers.</h3>
        </c:when>
        <c:otherwise>
            <b>${csbeans.SName} </b>
            <p>${csbeans.SStreet1} <br><span> ${csbeans.SStreet2}</span>${csbeans.SStreet3}</p>
            <p>${csbeans.SCity} <span>${csbeans.SZipcode}</span></p>
            <p>${csbeans.STelephone }</p>
            
        </c:otherwise>
</c:choose>
</td>
<td>
<img 
src="http://maps.googleapis.com/maps/api/streetview?size=400x400&location=<%=request.getParameter("lat")%>,<%=request.getParameter("lon")%>&heading=200&pitch=30&fov=60&sensor=false"
alt="Street View Image" width="150px" height="100px" style="cursor:pointer;"/>
           <br>
</td>
</tr>

</table>


</div>
<div align="center" id="map" style="height: 400px;width:100%"></div>

 

 

</body>
</html>