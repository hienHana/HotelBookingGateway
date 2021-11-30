<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<nav class="navbar navbar-inverse">
	      <div class="container">
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="navbar-brand" href="#">TravelGig</a>
	        </div>
			<div id="navbar" class="collapse navbar-collapse">
			  <ul class="nav navbar-nav">
				<li class="active"><a href="home">Home</a></li>
			  </ul>
			  
			  <ul class="nav navbar-nav navbar-right">
				<li><a href="login?logout">
					<!-- if not login -->
					<c:if test="${empty pageContext.request.userPrincipal.name}">
						Login
					</c:if>	
					<!-- if login -->			
				 	<c:if test="${not empty pageContext.request.userPrincipal.name}">
				 		Logout
				 	</c:if>
				</a></li>
				<li><a href="/getUserSignUpForm">Create account</a></li>
			  </ul>
			  
			  <ul class="nav navbar-nav navbar-right">
			  
			    <!-- if login -->			
				<c:if test="${not empty pageContext.request.userPrincipal.name}">
					<li><a class="yourBooking" data-toggle="modal" data-target="#yourBookingModal">Your Booking</a></li>
					<li><a class="yourReview" data-toggle="modal" data-target="#yourReviewModal">Your Review</a></li>
				</c:if>
				
				<li><a class='supportLink' data-toggle="modal" data-target="#supportModal">FAQs</a></li>
			  </ul>
			</div>
		  </div>
		</nav>

</body>
</html>