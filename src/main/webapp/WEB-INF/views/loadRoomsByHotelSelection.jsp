<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">	
	    <link href="css/bootstrap.min.css" rel="stylesheet">
	    <link href="css/style.css" rel="stylesheet">

		<title>My Travel Gig</title>
		
<!----------------  Script files --------------------------------------->

	    <script src="/js/jquery-2.1.1.min.js"></script>
	    <script type="text/javascript"  src="/js/loadHotels.js"></script>
		<script type="text/javascript"  src="/js/searchHotel.js"></script>
		<script type="text/javascript"  src="/js/loadRoomsFromHotelSelection.js"></script>
		<script type="text/javascript"  src="/js/booking.js"></script>
				
	</head>
	<body>


<!----------------------- navbar -------------------------------------->

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
				<li ><a href="home">Home</a></li>
			  </ul>
			  
			  <ul class="nav navbar-nav">
				<li class="active"><a href="rooms">Rooms</a></li>
			  </ul>
			  
			  <ul class="nav navbar-nav navbar-right">
				<li><a href="login">Sign in</a></li>
				<li><a href="#">Create account</a></li>
			  </ul>
			</div>
		  </div>
		</nav>
	
		
<!----------------------- breadcrumb -------------------------------------->

		<!-- <div id="breadcrumb">
			<div class="container">
				<ol class="breadcrumb">
					<li>Book Domestic and International hotels and homestays. To list your property <a data-toggle="modal" data-target="#addHotel">click here</a></li>
					</a><a href="admin.jsp">
					<li>Book Domestic and International hotels and homestays. To list your property <a href='/admin'>click here</a></li>
				</ol>
			</div>
		</div> -->
	
<!----------------------- Search bar -------------------------------------->
		 <!--  <div class="container">
		   <table id="searchBar">
		 	 <tr>
		 	 	<td>
			   		Search Hotel <br>
			    	<input type="text" id="searchHotel" placeholder="Enter City/Hotel/Area">
			  	</td>
			  	<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			  	<td>
				    CheckIn <br>
				    <input type="date" id='checkIn'>
				 </td>
				 <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				 <td>
				    CheckOut <br>
				    <input type="date" id='checkOut'>
			  	 </td>
			  	 <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			  	 <td>
				    Rooms <br>
				    <input type="number" id='noOfRooms' placeholder="# Rooms">
				  </td>
				  <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				  <td>
				    Guests <br>
				    <input type="number"  id='noOfGuests' placeholder="# Guests">
				  </td>
				  <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			  </tr>
			  
			  <tr>
			  	<td>
				  	<br>
				  	<button type="submit" id='searchBtn'>Search</button>
			  	</td>
			  </tr>
			</table>
		</div>		 -->
		
		
<!----------------------- view hotels -------------------------------------->
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
									<ul class="list-group list-unstyled hotelPopularFilters">
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
							<ul class="listHotel" hidden="hidden" >
								</ul>
								<h2 class="panel-title panelTitle">Rooms Available at <strong><span id="hotelnameSel"></span></strong></h2>
							</div>
							
							<div class="panel-body">
								<ul class="listHotel"  id= "roomDisplay">
								</ul>
								<!-- <ul class="roomDisplay" style="list-style-type:none">
								</ul> -->
							</div>
						</div>
					</div>
										
				</div>
			</div>
		</section>
		
		<!-- Search by Hotel Name:
		<input type="text" name="hotelName" id="hotelName" />
		<input type="button" value="Search by Hotel Name" id="searchHotelByName" /> -->
		
<!--------------------- footer -------------------------------------->
		<footer id="footer">
			<p>Copyright TravelGig, &copy;2020</p>
		</footer>






<!----------------------- Choose Hotel Modal		---------------------------->

<!-- <div class="modal fade" id="chooseHotelModal" tabindex="-1" role="dialog" aria-labelledby="chooseHotelModalLabel">
  <div class="modal-dialog modal-lg" role="document" >
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="chooseHotelModalLabel">Rooms Available at <span id="hotelnameSel"></span></h4>
        <div id="hotelImage"></div>
      </div>
      <div class="modal-body">
      	<ul class="roomDisplay" style="list-style-type:none">
		</ul>
       
      </div>
    </div>
  </div>
</div> -->


<!----------------------- Choose Room to Book Modal		---------------------------->

<div class="modal fade" id="chooseRoomlModal" tabindex="-1" role="dialog" aria-labelledby="selectLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"><strong>Book Now ...</strong> </h4>
      </div>
      <div class="modal-body" >
        <div class="form-group roomChosen">   
            					
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="confirmBook">Confirm Book</button>
      </div>
    </div>
  </div>
</div>

<!-----------------------		-------------------------------------->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>		
	</body>
</html>