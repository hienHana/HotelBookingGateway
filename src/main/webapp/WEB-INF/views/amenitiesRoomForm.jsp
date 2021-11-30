<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/createAmenitiesRoom" method="POST">
		<table>
			<tr>
				<td><b>AmenitiesRoom Form</b></td>
			</tr>
			
			<tr>
				<td><b>AmenitiesRoom Id:</b></td>
				<td><input name="amenityRoomId"/></td>
			</tr>
			
			<tr>
				<td><b>Amenities:</b></td>
				<td><input name="amenityRoom"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
			
		</table>
	</form >
</body>
</html>