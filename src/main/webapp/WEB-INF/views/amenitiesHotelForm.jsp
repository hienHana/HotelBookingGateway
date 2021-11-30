<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AmenitiesHotel Form</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/createAmenitiesHotel" method="POST" >
		<table>
			<tr>
				<td><b>AmenitiesHotel Form</b></td>
			</tr>
			
			<tr>
				<td><b>AmenitiesHotel Id:</b></td>
				<td><input name="amenityHotelId"/></td>
			</tr>
			
			<tr>
				<td><b>Amenities:</b></td>
				<td><input name="amenityHotel"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
			
		</table>
	</form >

</body>
</html>