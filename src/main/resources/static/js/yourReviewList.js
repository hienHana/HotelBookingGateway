//Button in home.jsp nav bar

/**************************** Your Review List ***************************************/
$( document ).ready(function() {
	$('.yourReview').click(function(){
		
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/getReviewByUserId",
			dataType : 'json',
			success : function(result) {
				alert('inside your reviewList.js');
				 $.each(result, function(key, value) {
					 $('#yourReviewLst').append("<div>You are here</div>");
					 
//					 $('#yourReviewLst').append(
//						 "<tr>" +
//							"<td>Star Rating: "+value.starRating+"</td>" +
//						 "</tr>" +	 
//						 "<tr>" +
//							"<td>Your Feedback: " + value.feedback +"</td>" +
//						 "</tr>" );
				 });

				 $.each(result, function(key1, value1) {				 
						console.log(value1);
					});
			},
			error : function(e) {
				alert("Error in load reviews !")
				console.log("ERROR: ", e);
			}
		})
		
	})
	

})