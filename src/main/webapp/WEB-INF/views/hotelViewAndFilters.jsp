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

	<section id="main">		
			<div class="container">
				<div class="row">
				
		<!---------------- Filters -------------------------------------->
					<div class="col-md-3">
						<h3><strong>Filters</strong></h3>
						<br>
						<table class="table table-hover table-bordered hotelFilters">
							<tr>
								<td>
									<h4><strong>Rating</strong></h4>
									<ul class="list-group list-unstyled ratingFilters">
									<li><input type="checkbox" class="star" value="3"> Star rating 3</li>
									  <li><input type="checkbox" class="star" value="4"> Star rating 4</li>
									  <li><input type="checkbox" class="star" value="5"> Star rating 5</li>
									  
									  <!-- <li><input type="checkbox" id="threeToFiveStar" value="3"> Star rating 3</li>
									  <li><input type="checkbox" id="fourToFiveStar" value="4"> Star rating 4</li>
									  <li><input type="checkbox" id="fiveStar" value="5"> Star rating 5</li> -->
									  <!-- <li><input type="checkbox" id="freeBreakfast" value="breakfast"> Free Breakfast</li>
									  <li><input type="checkbox" id="freeCancel" value="cancelation"> Free Cancellation</li> -->
									</ul>
								</td>
							</tr>
							
							<tr>
								<td>
									<h4><strong>Nightly Price</strong></h4>
									<ul class="list-group list-unstyled hotelPriceFilters">
									  <li><input type="checkbox" id="priceFilter"> under $100 </li>
									  <li><input type="checkbox" id="priceFilter"> $100 - $200</li>
									  <li><input type="checkbox" id="priceFilter"> $200 - $300</li>
									  <li><input type="checkbox" id="priceFilter"> $300 - $400</li>
									  <li><input type="checkbox" id="priceFilter"> $400 - $500</li>
									  <li><input type="checkbox" id="priceFilter"> above $500</li>
									</ul>
								</td>
							</tr>
							
							<tr>
								<td>
									<h4><strong>Amenities</strong></h4>
									<ul class="list-group list-unstyled hotelAmenities">
									  <li><input type="checkbox" id="amenitiesFilter"> Air conditioning</li>
									  <li><input type="checkbox" id="amenitiesFilter"> Airport Transfers</li>
									  <li><input type="checkbox" id="amenitiesFilter"> Free Breakfast</li>
									  <li><input type="checkbox" id="amenitiesFilter"> Free Parking</li>
									  <li><input type="checkbox" id="amenitiesFilter"> Free WiFi</li>
									  <li><input type="checkbox" id="amenitiesFilter"> Gym</li>
									  <li><input type="checkbox" id="amenitiesFilter"> Internet Access</li>
									  <li><input type="checkbox" id="amenitiesFilter"> Non-smoking</li>
									  <li><input type="checkbox" id="amenitiesFilter"> Parking available</li>
									  <li><input type="checkbox" id="amenitiesFilter"> Pool</li>
									  <li><input type="checkbox" id="amenitiesFilter"> Kids Area</li>
									</ul>
								</td>
							</tr>
						</table> 
					</div>
					
									
				<!------------------ Search and Filter Results ----------------------------->
					<div class="col-md-9">	
						<!-- Website overview -->
						<div class="panel panel-default">
							<div class="panel-heading main-color-bg">
								<h2 class="panel-title panelTitle"></h2>
							</div>
							
							<div class="panel-body">
								<ul class="listHotel" style="list-style-type:none">
								</ul>
							</div>
						</div>
					</div>
										
				</div>
			</div>
		</section>
		
		<!-- Search by Hotel Name:
		<input type="text" name="hotelName" id="hotelName" />
		<input type="button" value="Search by Hotel Name" id="searchHotelByName" /> -->

</body>
</html>