<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
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
<!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

  <!-- Three columns of text below the carousel -->
  <div class="row">
    <div class="col-md-4 text-center">
      <img class="img-circle" src="images/city.jpg" width="140px">
      <h2>City Name</h2>
      <p>Search by city name.  Not sure how to spell a city? Try your best and we'll find the closest cities that sound like your search entry.</p>
      <p><a class="btn btn-default" href="CoffeeSearch?type=City">City Name »</a></p>
    </div>
    <div class="col-md-4 text-center">
      <img class="img-circle" src="images/contact.jpg" width="140px">
      <h2>Zipcode</h2>
      <p>Want to search by zipcode? Simply enter all or part of a zipcode and we'll do the rest.</p>
      <p><a class="btn btn-default" href="CoffeeSearch?type=PostalCode">Zipcode »</a></p>
    </div>
    <div class="col-md-4 text-center">
      <img class="img-circle" src="images/locateme.png" width="140px">
      <h2>Locate Me</h2>
      <p>Give us permission to use your location and we'll let you know which coffee shops are nearby.</p>
      <p><a class="btn btn-default" id="btn-locate" href="CoffeeSearch?type=gps">Locate Me »</a></p>
    </div>
  </div><!-- /.row -->




  <!-- FOOTER -->
  <footer>
    <p class="pull-right"><a href="#">Back to top</a></p>
    <p>This Bootstrap layout is compliments of Bootply. · <a href="http://www.bootply.com/62603">Edit on Bootply.com</a></p>
  </footer>

</div><!-- /.container -->
	<!-- script references -->
		<script src="js/jquery-2.1.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/scripts.js"></script>
	</body>
</html>