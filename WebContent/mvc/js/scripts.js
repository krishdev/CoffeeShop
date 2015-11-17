$(document).ready(function(){
	$('#btn-locate').click(function(e){
	  if (navigator.geolocation)
	    {
	    	$(this).html("Please wait...");			    
		    navigator.geolocation.getCurrentPosition(function(position){
		    	window.location = "CoffeeSearch?type=gps&lat=" + position.coords.latitude + "&lon=" + position.coords.longitude;
	    	});
	    }
	  else
	  	{
	  		$(this).html("Sorry! It looks like Geolocation is not supported by this browser.");
	  	}
		  
	e.preventDefault();
	e.stopPropagation();
	});
});