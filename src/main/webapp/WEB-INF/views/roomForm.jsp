<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Room Form </title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/getRoomForm" method="POST" >
		<table>
			<tr>
				<td><b>Room Form</b></td>
			</tr>
			
			<tr>
				<td><b>Room Id:</b></td>
				<td><input name="roomId"/></td>
			</tr>
			
			<tr>
				<td><b>RoomType Id:</b></td>
				<td><input name="roomType"/></td>
			</tr>
			
			<tr>
				<td><b>Number of Rooms:</b></td>
				<td><input name="noRooms"/></td>
			</tr>
			<tr>
				<td><b>Price:</b></td>
				<td><input name="price"/></td>
			</tr>
			<tr>
				<td><b>Discount:</b></td>
				<td><input name="discount"/></td>
			</tr>
			<tr>
				<td><b>Description:</b></td>
				<td><input name="description"/></td>
			</tr>
			<tr>
				<td><b>Policies:</b></td>
				<td><input name="policies"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
			
		</table>
	</form >

</body>
</html>