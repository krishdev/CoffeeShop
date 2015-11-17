<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
		<meta charset="utf-8">
		<title>CoffeeShops Around Your Location</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="css/styles.css" rel="stylesheet">
              <title>Google Map API V3 with markers</title>
              
 <%--             <script src="http://maps.google.com/maps?file=api&v=2&key=ABQIAAAA496CbrflCxvduLD30wNsqhQq3tWW1UGy0rG7B4F3xzgSR63hWxSoz3WEdQlXbSF2-qEhMm4zqDCfRg" type="text/javascript"></script>
<script type="text/javascript">
function load(){
	
	var searchlat='<%= (String) request.getParameter("lat") %>';
	var searchlon='<%= (String) request.getParameter("lon") %>';
if (GBrowserIsCompatible()) {
var map = new GMap2(document.getElementById("map"));
map.setCenter(new GLatLng(searchlat,searchlon), 13);
mapTypeId: google.maps.MapTypeId.ROADMAP;

var point = new GLatLng(searchlat,searchlon);
map.setCenter(point, 14);
var marker = new GMarker(point);
map.addOverlay(marker);
}
}

</script>
  --%> <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
  <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.10.1.min.js"></script>
  
  
 
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
<!-- /.Controls -->

<div align="left">
<table>
<tr>
<td>
 <div class="col-md-4">
      <h2>Your Location & Near by CoffeeShops</h2>
      <p align="left">Showing Coffee Shops near by 5 miles.</p>
      <p><a class="btn btn-default" href="CoffeeSearch">Back to Home</a></p>
    </div>
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
 


  <div id="map" style="width:100%; height: 400px;"></div>
  <div align="center">
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
				<c:forEach items="${ mms }" var="cds">
	<tr>
	<td>
	<p>${cds.getName() }</p>
	</td>
	<td>
	<p>${cds.getCity() }</p><p>${cds.getZipcode() }
	</p>
	</td>
	<td>
	<p>
	<c:url value="CoffeeShopDetails" var="displayURL">
  <c:param name="id"   value="${cds.getId()}" />
     <c:param name="lat" value="${cds.getLati()}"/>
       <c:param name="lon" value="${cds.getLongi()}"/>
  
</c:url>
<a href='<c:out value="${displayURL}" />'>Details</a>		
	
	
	</p>
	</td>
	</tr>
				</c:forEach>

</table></div>
  <script type="text/javascript">
    // Define your locations: HTML content for the info window, latitude, longitude
    var lat='<%= (String) request.getParameter("lat") %>';
    var lon='<%= (String) request.getParameter("lon") %>';
    var nam='USER';
    var lat1= '<%= request.getAttribute("lat1") %>';
    var lon1='<%= request.getAttribute("lon1") %>';
    var lat2='<%= request.getAttribute("lat2") %>';
    var lon2='<%= request.getAttribute("lon2") %>';
    var nam1='<%= request.getAttribute("nam1") %>';
    var nam2='<%= request.getAttribute("nam2") %>';
if(lon1 != 'undefined' && (lon1.length>0 || lon1.length<0)){
	var locations = [
                     [nam,lat,lon],
      [nam1 , lat1, lon1],
      [nam2 , lat2, lon2]
    ];
}
else
	var locations = [
                     [nam,lat,lon]
    ];
    
    
    // Setup the different icons and shadows
    var iconURLPrefix = 'http://maps.google.com/mapfiles/ms/icons/';
    
    var icons = [
      iconURLPrefix + 'red-dot.png',
      iconURLPrefix + 'green-dot.png',
      iconURLPrefix + 'blue-dot.png',
      iconURLPrefix + 'orange-dot.png',
      iconURLPrefix + 'purple-dot.png',
      iconURLPrefix + 'pink-dot.png',      
      iconURLPrefix + 'yellow-dot.png'
    ]
    var icons_length = icons.length;
    
    
    var shadow = {
      anchor: new google.maps.Point(15,33),
      url: iconURLPrefix + 'msmarker.shadow.png'
    };

    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 10,
      center: new google.maps.LatLng(-37.92, 151.25),
      mapTypeId: google.maps.MapTypeId.ROADMAP,
      mapTypeControl: false,
      streetViewControl: false,
      panControl: false,
      zoomControlOptions: {
         position: google.maps.ControlPosition.LEFT_BOTTOM
      }
    });

    var infowindow = new google.maps.InfoWindow({
      maxWidth: 160
    });

    var marker;
    var markers = new Array();
    
    var iconCounter = 0;
    
    // Add the markers and infowindows to the map
    for (var i = 0; i < locations.length; i++) {  
      marker = new google.maps.Marker({
        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
        map: map,
        icon : icons[iconCounter],
        shadow: shadow
      });

      markers.push(marker);

      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
            infowindow.setContent(locations[i][0]);
          infowindow.open(map, marker);
        }
      })(marker, i));
      
      iconCounter++;
      // We only have a limited number of possible icon colors, so we may have to restart the counter
      if(iconCounter >= icons_length){
      	iconCounter = 0;
      }
    }

    function AutoCenter() {
      //  Create a new viewpoint bound
      var bounds = new google.maps.LatLngBounds();
      //  Go through each...
      $.each(markers, function (index, marker) {
        bounds.extend(marker.position);
      });
      //  Fit these bounds to the map
      map.fitBounds(bounds);
    }
    AutoCenter();
  </script> </body>
</html>