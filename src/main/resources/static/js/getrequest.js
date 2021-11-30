$( document ).ready(function() {
	
	var url = "http://localhost:8282";
	
	// GET REQUEST
	$("#getBtn").click(function(event){
		event.preventDefault();
		ajaxGet();
	});
	
	// DO GET
	function ajaxGet(){
		$.ajax({
			type : "GET",
			url : url + "/getcustomer",
			success: function(result){
					alert(result);
					$('#getResultDiv .list-group li').remove();
					var custList = "";
					$.each(result, function(i, customer){
						var customer = "Customer " + i + ": FirstName=" + customer.firstname + " ,LastName=" + customer.lastname + "<br\>";
						$('#getResultDiv .list-group').append('<li><h4 class="list-group-item">'+customer+'</h4></li>')
			        });
					console.log("Success: ", result);
				
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
		});	
	}
})