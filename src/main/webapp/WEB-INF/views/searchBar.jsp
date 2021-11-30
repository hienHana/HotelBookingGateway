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
	 <div class="container">
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
		</div>		
		
		<%-- </c:if> --%>

<!-- if login -->			
			<%-- <c:if test="${not empty pageContext.request.userPrincipal.name}">
				<h2 class="font-weight-bold">
					${pageContext.request.userPrincipal.name}, welcome! 
				</h2>				
				
			<table>
				<tr>
					<sec:authorize access="hasAuthority('user')">		
						<td >
							<a class="bookingPage" href="/bookingResult">
								<h4 class="font-weight-bold" >ViewBooking</h4>
							</a>&nbsp;&nbsp;&nbsp;&nbsp;
						</td>				
					</sec:authorize>
			
					<!-- <sec:authorize access="hasAuthority('admin')">
						<td><a href="/admin">The Admin Page</a>&nbsp;&nbsp;&nbsp;</td>							
					</sec:authorize> -->
				</tr>
			</table>
				
</c:if> --%>
	
</body>
</html>