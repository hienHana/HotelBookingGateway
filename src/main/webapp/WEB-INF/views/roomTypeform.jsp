<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>RoomType Form</title>
	<style type="text/css" >
		.error{
			color: red;
		}
	</style>

</head>
<body >
	<form action="${pageContext.request.contextPath}/createRoomType" method="POST">
		<table>
			<tr>
				<td><b>RoomType Form</b></td>
			</tr>
			
			<tr>
				<td><b>RoomType Id:</b></td>
				<td><input name="roomTypeId"/></td>
			</tr>
			
			<tr>
				<td><b>Type:</b></td>
				<td><input name="typeRoom"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
			
		</table>
	</form >
	
	
	<%-- <form:form action="createRoomType" method="POST" modelAttribute="roomType">
		<table>
			<tr>
				<td><b>RoomType Form</b></td>
			</tr>
			
			<tr>
				<td><b>RoomType Id:</b></td>
				<td><form:input path="roomTypeId"/></td>
				<td><form:errors path="roomTypeId"  cssClass="error"/></td>
			</tr>
			
			<tr>
				<td><b>Type:</b></td>
				<td><form:input path="typeRoom"/></td>
				<td><form:errors path="typeRoom"  cssClass="error"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
			
		</table>
	</form:form> --%>
	
</body>
</html>