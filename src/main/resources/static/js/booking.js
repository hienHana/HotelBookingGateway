
$(document).ready(function(){
	
	/*****************  Booking ******************************/ 
	
    $(".roomDisplay").on('click', 'button', function(){
    	var hotelNameSel = $(this).parent().parent().parent().parent().find('#selHotelName').text();
    	var hotelIdSel = $(this).parent().parent().parent().parent().find('#selHotelId').text();
    	console.log(hotelIdSel + ", "+hotelNameSel)
		
    	var roomIdSel =  $(this).parent().parent().find('#roomid').text();
		 console.log(roomIdSel);
		 
		 var roomTypeSel =  $(this).parent().parent().find('#typeRoom').text();
		 var roomprice = $(this).parent().parent().find('#rmprice').text();
		 console.log(roomTypeSel + ", $"+roomprice);
		 
		 $(".roomChosen").empty();
			 
		 $(".roomChosen").append(
			"<div id='selRoomId1' hidden='hidden'>" + roomIdSel + "</div>" +
			"<div id='selHotelId1' hidden='hidden'>" + hotelIdSel + "</div>" +
		   "<div class='form-group'>" +
			 "<div class='form-group'>" +
				"<label>Hotel Name</label> " +
				"<input type='text' id='typeRoom1' class='form-control' value="+ hotelNameSel + "></input>" +
			 "</div>" +
			 "<div class='form-group'>" +
				"<label>No. Guests</label>" +
				"<input type='number' id='noguests' name='noguests' class='form-control'/>" +							
			 "</div>" +
			 "<div class='form-group'>" +
				"<label>No. Rooms</label>" +
				"<input type='number' id='norooms' name='norooms'  class='form-control' />" +							
			 "</div>" +
			 "<div class='form-group'>" +
				"<label>CheckInDate</label>" +
				"<input type='date' id='checkIn1' class='form-control'>" +							
			 "</div>" +
			 "<div class='form-group'>" +
				"<label>CheckOutDate</label>" +
				"<input type='date' id='checkOut1' class='form-control'>" +							
			 "</div>" +
			 "<div class='form-group'>" +
				"<label>Room Type</label>" +
				"<input type='' class='form-control' value="+roomTypeSel + ">" +							
			 "</div>" +
			"<div class='form-group'>" +
				"<label>Price Per Night</label>" +
				"<input type='number' id='rprice1' class='form-control' value="+ roomprice + "></input>" +								
			"</div>" +
		"<div>" +
		"<div>&nbsp</div>");
    });	
    
				 

/*****************  Confirm booking ******************************/ 
    
    $("#confirmBook").click(function(){
    	var hotelId = $(this).parent().parent().find('#selHotelId1').text();   	
    	var roomId = $(this).parent().parent().find('#selRoomId1').text();
    	var roomPrice = $(this).parent().parent().find('#rprice1').val();
    	var checkin = $("#checkIn1").val();
    	var checkout = $("#checkOut1").val();
    	var noGuests = $("#noguests").val();
    	var noRooms = $("#norooms").val();
    	var totalPrice = roomPrice * noRooms;
    	
    	console.log("noGuests: "+ noGuests +", noRooms: " +noRooms);
    	
    	var bookingDetail = {
    			"checkIn": checkin,
    			"checkOut": checkout,
    			"hotelId": hotelId,
    			"roomId": roomId,
    			"noOfGuests": noGuests,
    			"noOfRooms":noRooms, 			
    			"totalPrice":totalPrice,
    			"status":"pending",
    			"discount":0 			
    	}	
   
    	
		$('.bookingConfirm').empty();
		 $.ajax({
			 	type : "POST",
				contentType : "application/json",
				url : "/saveBooking",
				data: JSON.stringify(bookingDetail),
				dataType : 'json',
				success : function(result) {
//					window.location.href ="/login";
//					$.each(result, function(key, value) {
						$('.bookingConfirm').append(
								"<div>You are booked</div>" 		
						);	
//					});
	 				$.each(result, function(key, value) {
	 					console.log(value);		 				
	 				});
	 				
			},
			error : function(e) {
				alert("Error in confirm booking !")
				console.log("ERROR: ", e);
			}
  
	    	});
    
    });  
    
	
})