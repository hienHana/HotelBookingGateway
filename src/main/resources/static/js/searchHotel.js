var checkDate = [];

$( document ).ready(function() {
	
/***************** Load result hotels from the search bar *******************************/
	
    $("#searchBtn").click(function(event) {
    	var searchDetails = {
    			"searchHotel" : $("#searchHotel").val(),
    			"checkIn" :  $("#checkIn").val(),
    			"checkOut" :  $("#checkOut").val(),
    			"noOfRooms" :  $("#noOfRooms").val(),
    			"noOfGuests" :  $("#noOfGuests").val()
    			
        }
    	
    	checkDate[0] = $("#checkIn").val();
    	checkDate[1] = $("#checkOut").val();
	    	
    	$('.listHotel li div').parents('li').remove();
	    	$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "/getHotels",
				data: JSON.stringify(searchDetails),
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
								 "<li>" +
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
					 	
					 $('input:checkbox').removeAttr('checked'); //clear all the check boxes
					 
					 $.each(result, function(key1, value1) {
						console.log(value1);
					});
					
				},
				error : function(e) {
					alert("Error!")
					console.log("ERROR: ", e);
				}
	    	});
    	
	});
    
    			
    
/*****************  Load hotels from filters ******************************/
    
    $('input[type=checkbox]').on('change', function() {
    	$(".listHotel li").hide();
//    	$("#hotels").hide();
//      var rows = $(".listHotel").children('li');
    	var rows = $(".listHotel").children();
        if($(this).is(':checked'))    {   
            var starCheck = $(".star:checked"); //get all the selected stars checked
            $.each(starCheck, function(key1, value1){
        	   var selectstar = $(this).val();               
	            $.each(rows, function(key, value){ 
	            	star = $(this).find('#starRating').text();
	            	console.log(star);
                    if(star == selectstar ){
                    	$(this).show();
                    	console.log($(this).text());
                    } 
	            }) ; 
            }) ; 
        } else{ //if unchecked
        	 var starCheck = $(".star:checked"); //get all the selected stars checked
             if(starCheck.length == 0){
            	 $(".listHotel li").show();
            	 $.each(rows, function(key, value){ 
            		 star = $(this).find('#starRating').text();
                      if(star == selectstar ){
                      	$(this).toggle();
                      } 
  	            }) ;
             }else{
	             $.each(starCheck, function(key1, value1){
	         	   var selectstar = $(this).val();               
	 	            $.each(rows, function(key, value){ 
	 	            	star = $(this).find('#starRating').text();
	                     if(star == selectstar ){
	                     	$(this).show();
	                     } 
	 	            }) ; 
	             }) ; 
             }
        }   
    });
    
    
    
/*****************  display hotelAmenities options in "addHotel" modal ***************/
    
    $("#hotel_amenities").click(function(event) {
    	$.ajax({
			type : "GET",
			contentType : "application/json",
			url : searchMicroservice + "/getHotelAmenities",
			dataType : 'json',
			success : function(result) {				
				 $.each(result, function(key1, value1) {
					 $(".hotel_amenitiesSel").append(
								"<option value="+value1.amenityHotel+">"+value1.amenityHotel+"</option>");
				});
				
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
    	});
	});
    
    
/*****************  get and display roomType options in "addRoom" modal  *****************/
    
    $("#roomType").click(function(event) {
    	$.ajax({
			type : "GET",
			contentType : "application/json",
			url : searchMicroservice + "/getRoomType",
			dataType : 'json',
			success : function(result) {
				$.each(result, function(key1, value1) {
					 $(".roomTypeSel").append(
					"<option value="+value1.typeRoom+">"+value1.typeRoom+"</option>");
				});
				
				 $.each(result, function(key1, value1) {
					console.log(value1.typeRoom);
				});
				
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
    	});
	});
      
/*****************  get and display roomAmenities options in "addRoom" modal ******************/
    
    $("#room_amenities").click(function(event) {
    	$.ajax({
			type : "GET",
			contentType : "application/json",
			url : searchMicroservice + "/getRoomAmenities",
			dataType : 'json',
			success : function(result) {
				$.each(result, function(key1, value1) {
					 $(".room_amenitiesSel").append(
					"<option value="+value1.amenityRoom+">"+value1.amenityRoom+"</option>");
				});
				
				 $.each(result, function(key1, value1) {
					console.log(value1.amenityRoom);
				});
				
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
    	});
	});
   
   
})