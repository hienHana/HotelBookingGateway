$( document ).ready(function() {
	
	$(".yourBooking").click(function(){
		$(".bookingList").empty();
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/getBookingByUserId",
			dataType : 'json',
			success : function(result) {
				 $.each(result, function(key, value) {
					 
					 $(".bookingList").append(
					   "<tbody>" +	 
						 "<tr>" +
							"<td style='color:blue' colspan='5'><strong>Booking Id: <span id='bookingid'>" + value.bookingId +"</span></strong></td>" +
							"<td><button type='button' class='feedbackBtn' data-toggle='modal' data-target='#feedbackModal' data-dismiss='modal'>Review</button></td>" +
							"<td><button type='button' class='cancelBtn' data-toggle='modal' data-target='#cancelModal' data-dismiss='modal'>Cancel Booking x</button></td>" +
						 "</tr>" +	 
						 "<tr>" +
							"<td id='hotelname'>Hotel Name: " + value.hotelName +"</td>" +
						 "</tr>" +
						 "<tr>" +
							"<td colspan='2' id='roomtype'>Room Type: "+value.roomType+"</td>" +
							"<td colspan='2' id='checkin'>CheckIn date: "+value.checkIn+"</td>" +
							"<td colspan='2' id='checkout'>CheckOut date: "+value.checkOut+"</td>" +
						 "</tr>" +
						 "<tr>" +
							 "<td colspan='2' id='numberofroom'>Number of Rooms: "+value.noRooms+"</td>" +
							 "<td colspan='2' id='numberofguests'>Number of Guests: "+value.noGuests+"</td>" +
						 	"<td colspan='2' id='totalprice'>Total Price: "+value.totalPrice+"</td>" +
						 "</tr>" +
						"</tbody>" );
				 	});
				 
			/********************* Cancel Booking ****************************/	 
				 $('.cancelBtn').click(function(event){
					 var bookingId = $(this).parent().parent().find('#bookingid').text();
					 var bookingIdNum = parseInt(bookingId);
					 var bookingIdRes = 0;
					 $('.canelItem').empty();
					 $.each(result, function(key, value) {
						 if(value.bookingId == bookingIdNum) {
							 bookingIdRes = value.bookingId;
							 $('.canelItem').append(
							   "<tbody>" +
								 "<tr>" +
									"<td colspan='6'><strong>Booking Id: " + value.bookingId +"</strong></td>" +
								 "</tr>" +	 
								 "<tr>" +
									"<td id='hotelname1'>Hotel Name: " + value.hotelName +"</td>" +
								 "</tr>" +
								 "<tr>" +
									"<td colspan='2' id='roomtype1'>Room Type: "+value.roomType+"</td>" +
									"<td colspan='2' id='checkin1'>CheckIn date: "+value.checkIn+"</td>" +
									"<td id='checkout1'>CheckOut date: "+value.checkOut+"</td>" +
								 "</tr>" +
								 "<tr>" +
									 "<td colspan='2' id='numberofroom1'>Number of Rooms: "+value.noRooms+"</td>" +
									 "<td colspan='2' id='numberofguests1'>Number of Guests: "+value.noGuests+"</td>" +
								 	"<td colspan='2' id='totalprice1'>Total Price: "+value.totalPrice+"</td>" +
								 "</tr>"+
								"</tbody>" );
							 var tbody = $(event.target).closest("tbody");
							 tbody.remove();
							 $('#cancelConfirm').click(function(){
								 console.log("bookingIdRes "+bookingIdRes);
								 $.ajax({
										type : "GET",
										contentType : "application/json",
										url : "/cancelBooking/"+ bookingIdRes,
										dataType : 'json',
										success : function(result) {
											alert("Your booking "+ bookingIdNum + ' is cancelled.');
										},
										error : function(e) {
											alert("Error in cancel booking!")
											console.log("ERROR: ", e);
										}
								 		
								 }); 			
							 });
							 
						 }
						 $('listAfterCancel').append(value);
					 });			 					 
				 });
				 
				 
				 /**************************** Feedback **************************************/
				 
				 $('.feedbackBtn').click(function(event){
					 $('.yourFeedback').empty();
					 var bookingId1 = $(this).parent().parent().find('#bookingid').text();
					 var bookingIdNum1 = parseInt(bookingId1);
					 var bookingIdRes1 = 0;
					 $.each(result, function(key, value) {
						 if(value.bookingId == bookingIdNum1) {
							 bookingIdRes1 = value.bookingId;
							 $('.yourFeedback').append(
										"<div>" +
											
											 "<div>" +
											 	"<textarea id='writingFeedback' name='writingFeedback' rows='8' cols='50'></textarea>"+
											 "</div>" +
											 "<div><bold>Please Rate Your Experience: </bold><br>" +
											  
//											  $.each(result, function(key1, value1) {
//													 var star = "";					 
//													 for(var i=0; i<value1.star; i++){
//														 star += "<span class='glyphicon glyphicon-star' style='color:#FFCC00;' aria-hidden='true'></span>";
//													 }
											 
											 
											 	"<input type='checkbox' class='ratingExp' value=0>0 star" +
												"<input type='checkbox' class='ratingExp' value=1>1 star" +
												"<input type='checkbox' class='ratingExp' value=2>2 star" +
												"<input type='checkbox' class='ratingExp' value=3>3 star" +
												"<input type='checkbox' class='ratingExp' value=4>4 star" +
												"<input type='checkbox' class='ratingExp' value=5>5 star <br>" +
											 "</div>" +
										"</div>");
									
							 /************************** Send feed back to Controller ****************************/
									$('.ratingExp').click(function(e) {
										if($(this).is(':checked')) {
											var feedbackRating = $(this).val();
											var feedbackText = $('textarea').val();
											console.log(feedbackText);
												var feedbackObj ={
													"bookingId": bookingIdRes1,
													"starRating":feedbackRating, 
													"feedback": feedbackText
												}
												
												console.log(feedbackObj);
												$('#sendYourFeedback').click(function(){
													 console.log("bookingIdRes1 "+bookingIdRes1);
													 $.ajax({
															type : "POST",
															contentType : "application/json",
															url : "/saveFeedback",
															data: JSON.stringify(feedbackObj),
															dataType : 'json',
															success : function(result) {
																alert("Your Review sent successful!")
															},
															error : function(e) {
																alert("Error in feedback1!")
																console.log("ERROR: ", e);
															}
													 		
													 }); 			
												 });
										}
								    });
							 
									
									
						 }
					 });			 					 
				 });
				 			 
				 $.each(result, function(key1, value1) {
					console.log(value1);
				});
				
			},
			error : function(e) {
				alert("Error in loading booking list!")
				console.log("ERROR: ", e);
			}
    	});
	});
	
	
	
})