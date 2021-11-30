
/*****************  Load Rooms from hotel selection ******************************/ 


$(document).ready(function() {	

    $(".listHotel").on('click', 'button', function(){
		 var hotelNameSel =  $(this).parent().parent().parent().parent().find('#hotelNameSel').text();
		 var hotelIdSel =  $(this).parent().parent().parent().parent().find('#hotelIdSel').text();
		 $("#hotelnameSel").text(hotelNameSel);
		 $(".roomDisplay").empty();
		 
		 console.log(checkDate[0] +  " "+ checkDate[1]);
		 
		 var searchUri = "";
		 if(checkDate[0] == undefined ){
			 searchUri = "/getRoomsByHotelId/" + hotelIdSel;
		 }else{
			 searchUri = "/getRoomByHotelId/" + hotelIdSel+"/"+checkDate[0];
		 }
			 
		 
		 $.ajax({
				type : "GET",
				contentType : "application/json",
				url : searchUri,
				dataType : 'json',
				success : function(result) {
					
					 $(".roomDisplay").append(
							 "<h3 id='selHotelName'>"+ hotelNameSel +"</h3>" +
							 "<div id='selHotelId' hidden='hidden'>"+ hotelIdSel+ "</div>");
					 
					 $.each(result, function(key, value) {				 
						 $(".roomDisplay").append(
							 "<li>" +								   
							   "<div class='container'>" + 							   	  
								 	"<div class='col-md-3'>" +
								 		"<img src='#' alt='RoomImage' width='150' height='100'>" +
								 	"</div>" + 
								 	"<div class='col-md-3'>" +
								 	  	"<ul style='list-style-type:none'>" +
								 	  		"<li id='roomid' style='display:none'>" + value.roomId + "</li>" + 
								 	  		"<li id='roomTypeId' style='display:none' >" + value.roomType.roomTypeId + "</li>" +
									 	  	"<li id='typeRoom'>" + value.roomType.typeRoom + "</li>" + 
									 	  	"<li>$<span id='rmprice'>"+ value.price  + "</span> per Night</li>" +
									 	 "</ul>" +	
								 	"</div>" + 
								 	"<div class='col-md-3'>" +	
								 		"<button type='button' class='btn btn-primary' data-toggle='modal' data-target='#chooseRoomlModal' data-dismiss='modal'>ChooseRoom</button>" +								 		  
								 	"</div>" +
								  "</div>" + 
								 "</li>" +
								 "<li>&nbsp</li>");	 				  
					 	});
		 
		 				$.each(result, function(key, value) {
		 					console.log(value);		 				
		 				});
					
					},
					error : function(e) {
						alert("Error!")
						console.log("ERROR: ", e);
					}

	    	});
    });
});
