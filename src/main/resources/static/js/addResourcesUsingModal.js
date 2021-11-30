
$(document).ready(function(){
	/******************** Add Room using modal **********************/
    $("#roomSave").click(function(event) {
    	var roomDetails = {
    			"roomType" : $("#roomType").val(),
    			"room_amenities" :  $("#room_amenities").val(),
    			"description" :  $("#description").val(),
    			"quantity" :  $("#quantity").val(),
    			"price" :  $("#price").val()
    			
        }

    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : searchMicroservice + "/createRoom",
			data: JSON.stringify(roomDetails),
			dataType : 'json',
			success : function(result) {				
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
    
	
	
	/*****************  Add Hotel using modal **********************************/
    
    $("#hotelSave").click(function(event) {
    	var hotelDetails = {
    			"hotelname" : $("#hotelname").val(),
    			"address" :  $("#address").val(),
    			"city" :  $("#city").val(),
    			"state" :  $("#state").val(),
    			"email" :  $("#email").val(),
    			"mobile" : $("#mobile").val(),
    			"imageUrl" :  $("#imageUrl").val(),
    			"star" :  $("#star").val(),
    			"hotel_amenities" :  $("#hotel_amenities").val()
    			
        }

    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : searchMicroservice + "/createHotel",
			data: JSON.stringify(hotelDetails),
			dataType : 'json',
			success : function(result) {				
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
})