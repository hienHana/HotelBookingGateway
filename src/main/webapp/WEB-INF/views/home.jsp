 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<script type="text/javascript"  src="/js/support.js"></script>	
		<script type="text/javascript"  src="/js/yourBooking.js"></script>
		<script type="text/javascript"  src="/js/yourReviewList.js"></script>
		
	</head>
	<body>


<!----------------------- navbar -------------------------------------->

	<jsp:include page='header.jsp'/><br>  
		

<!----------------------- breadcrumb -------------------------------------->

		<div id="breadcrumb">
			<div class="container">
				<ol class="breadcrumb">
					<li>Book Domestic and International hotels and homestays. To list your property <a href='${pageContext.request.contextPath}/admin'>click here</a></li>
				</ol>
			</div>
		</div>
	
<!----------------------- Search bar -------------------------------------->

	<jsp:include page='searchBar.jsp'/><br>
			
		
<!----------------------- view hotels -------------------------------------->

	<jsp:include page='hotelViewAndFilters.jsp'/><br>
		
<!--------------------- footer -------------------------------------->
		<footer id="footer">
			<p>Copyright TravelGig, &copy;2020</p>
		</footer>

<!----------------------- Choose Hotel Modal		---------------------------->

<div class="modal fade" id="chooseHotelModal" tabindex="-1" role="dialog" aria-labelledby="chooseHotelModalLabel">
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
</div>


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
        <button type="button" class="btn btn-primary"  id="confirmBook" data-toggle='modal' data-target='#showConfirmationModal' data-dismiss="modal">Confirm Book</button>
      </div>
    </div>
  </div>
</div>


<!----------------------- Booking Confirmation Modal		---------------------------->

<div class="modal fade" id="showConfirmationModal" tabindex="-1" role="dialog" aria-labelledby="selectLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"><strong>Your booking is completed!</strong> </h4>
      </div>
      <div class="modal-body" >
        <div class="form-group bookingConfirm">   
            					
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>


<!----------------------- Your Booking List Modal		---------------------------->
<div class="modal fade" id="yourBookingModal" tabindex="-1" role="dialog" aria-labelledby="selectLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"><strong>Your Booking</strong> </h4>
      </div>
      <div class="modal-body" >
        <div class="form-group ">   
        	<table class='table table-striped bookingList'>
        	</table>
		</div>
      </div>
      <div class="modal-footer">
           <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>


<!----------------------- Cancel Booking Modal		---------------------------->
<div class="modal fade" id="cancelModal" tabindex="-1" role="dialog" aria-labelledby="selectLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"><strong>Are You Sure You Want To Cancel the Booking Below?</strong> </h4>
      </div>
      <div class="modal-body" >
        <div class="form-group ">   
        	<table class='table canelItem'>
        	</table>
		</div>
      </div>
      <div class="modal-footer">
           <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
           <button type="button" class="btn btn-primary"  id="cancelConfirm" data-toggle='modal' data-target='#cancelConfirmModal' data-dismiss="modal">Confirm Cancel Booking</button>
      </div>
    </div>
  </div>
</div>


<!----------------------- Give Feedback Modal		---------------------------->
<div class="modal fade" id="feedbackModal" tabindex="-1" role="dialog" aria-labelledby="selectLabel">
  <div class="modal-dialog modal-md" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Your Feedback</h4>
      </div>
      <div class="modal-body" >
        <div class="form-group yourFeedback">   
   
		</div>
      </div>
      <div class="modal-footer">
           <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
           <button type="button" class="btn btn-primary" id="sendYourFeedback" data-dismiss="modal">Send Feedback</button>
      </div>
    </div>
  </div>
</div>


<!----------------------- Your List of Reviews Modal		---------------------------->
<div class="modal fade" id="yourReviewModal" tabindex="-1" role="dialog" aria-labelledby="selectLabel">
  <div class="modal-dialog modal-md" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Your Review </h4>
      </div>
      <div class="modal-body" >
        <div class="form-group" id="yourReviewLst">   
   			<!-- <table class="table table-striped" id="yourReviewLst">
        	</table> -->
		</div>
      </div>
      <div class="modal-footer">
           <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!----------------------- Support Modal		---------------------------->
<div class="modal fade" id="supportModal" tabindex="-1" role="dialog" aria-labelledby="selectLabel">
  <div class="modal-dialog modal-md" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"><strong>Q&A</strong> </h4>
      </div>
      <div class="modal-body" >
        <div class="form-group">   
			<ul id="qa">			
			</ul>
			<sec>	
				Can't Find Your Answer? <a id="sendemail" data-toggle="modal" data-target="#emailModal" data-dismiss="modal">Send Us Your Question</a>
			</sec>	
		</div>
      </div>
      <div class="modal-footer">
           <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>


 <!----------------------- Email Modal		---------------------------->
 <div class="modal fade" id="emailModal" tabindex="-1" role="dialog" aria-labelledby="selectLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"></h4>
      </div>
      <div class="modal-body " >
        <div class="form-group theEmail">   
			<div class='form-group'>
				<div class='form-group'>
					<label>Subject</label>
					<input type='text' id='subject1' class='form-control'>							
				 </div>
				<div class='form-group'>
					<label>Body</label>
					<textarea id='textbody1' name='textbody1' rows='20' cols='50' class='form-control'></textarea>							
				 </div>
			 </div >
		</div>
      </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-primary"  data-dismiss="modal" id="send" >Send</button>
      </div>
    </div>
  </div>
</div>

<!-----------------------		-------------------------------------->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>		
	</body>
</html> 
