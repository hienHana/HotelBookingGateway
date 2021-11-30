$(document).ready(function(){
	
/***************** List of QA *****************/	
	$('.supportLink').click(function(){
		$('#qa').empty();
		$.ajax({
		 	type : "GET",
			contentType : "application/json",
			url : "/getQA",
			dataType : 'json',
			success : function(result) {
				$.each(result, function(key, value) {
					$('#qa').append(
						"<li id='question'>"+value.question+"</li>" +
						"<li id='answer' style='list-style-type:none'>"+value.answer+"</li>" +
						"<li style='list-style-type:none'>&nbsp</li>");
				});
					$.each(result, function(key, value) {
						console.log(value);		 				
					});
					
		},
		error : function(e) {
			alert("Error in load Q&A !")
			console.log("ERROR: ", e);
		}
	
		});

	})
	
	
/************* Send the email created in home.jsp ************/
	$('#send').click(function(){	
		var emailCombine = {
			"subject": $('#subject1').val(),
			"textbody":$('#textbody1').val()
		}
	
		console.log(emailCombine);
		$.ajax({
		 	type : "POST",
			contentType : "application/json",
			url : "/sendemail",
			data: JSON.stringify(emailCombine),
			dataType : 'json',
			success : function(result) {			
					$.each(result, function(key, value) {
						console.log(value);		 				
					});
					
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	
		});

	})	
	
})