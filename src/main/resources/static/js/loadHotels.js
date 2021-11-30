
/**************    Load all hotels when website starts *****************/

$( document ).ready(function() {
	
	loadFunction();
	
	
	function loadFunction(){
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/getAllHotels",
			dataType : 'json',
			success : function(result) {
				 $.each(result, function(key1, value1) {
					 var star = "";	
					 var cusStar = "";
					 for(var i=0; i<value1.star; i++){
						 star += "<span class='glyphicon glyphicon-star' style='color:#FFCC00;' aria-hidden='true'></span>";
					 }
					 
					 for(var i=0; i<value1.customerRating; i++){
						 cusStar += "<span class='glyphicon glyphicon-star' style='color:#FFCC00;' aria-hidden='true'></span>";
					 }
					 
					 
					 $(".listHotel").append(							 
							 "<li id='hotels'>" +
							   "<h3>"+ value1.hotelName +"<br><small>" + value1.description + "</small></h3>" +
							   "<div class='container'>" + 							   	  
								 	"<div class='col-md-3'>" +
								 		"<img src= 'http://localhost:8282/images/"+ value1.imageUrl+"' width='150' height='100'>" +
								 	"</div>" + 
								 	"<div class='col-md-3'>" +
								 	  	"<ul style='list-style-type:none'>" +
								 	  		"<li hidden='hidden' id='hotelIdSel'>" + value1.hotelId + "</li>" +
									 	  	"<li id='hotelNameSel'>" + value1.hotelName + "</li>" +  
									 	  	"<li>" +  value1.city +", "+ value1.state + "</li>" + 
									 	  	"<li>" +  value1.mobile+ "</li>" +  
									 	  	"<li>" +  value1.email + "</li>" + 
									 	  	"<li>CustomerRating " +  cusStar + "</li>" + 
									 	 "</ul>" +	
								 	"</div>" + 
								 	"<div class='col-md-3'>" +
								 		  "<ul style='list-style-type:none'>" +
								 		  	"<li>from $" + value1.minPrice + "</li>" +
								 		  	"<li id='starRating' hidden='hidden'>" + value1.star + "</li>" +
								 		  	"<li>" + star+ "</li>" +
								 		  	"<li>&nbsp</li>" +
								 		  	"<li><button type='button' class='chooseHotelBtn' data-toggle='modal' data-target='#chooseHotelModal'>Select</button></li>" +					
								 		  "</ul>" +
								 	"</div>" +
								  "</div>" + 
								 "</li>" );
				 	});
				 
				 $.each(result, function(key1, value1) {
					console.log(value1);
				});
				
			},
			error : function(e) {
				alert("Error in loading Hotels!")
				console.log("ERROR: ", e);
			}
    	});
	}
	
	
});