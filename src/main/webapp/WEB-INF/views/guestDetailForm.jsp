<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Guest Detail Form</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">

</head>

<body>
	<form action="${pageContext.request.contextPath}/createGuestDetail" method="POST" >
		<table class="table table-dark">
			<tr><th colspan="3">Guest Detail Form</th></tr>
			<!-- <tr>
				<td>Guest Id: </td>
				<td><input type="number" name="guestId"/></td>
			</tr> -->
			
			<tr>
				<td>Guest Name:</td>
				<td><input type="text" name="guestName"/></td>
			</tr>
			
			<tr>
				<td>Guest Address:</td>
				<td><input type="text" name="address"/></td>
			</tr>
			
			<tr>
				<td>Guest Age:</td>
				<td><input type="number" name="guestAge"/></td>
			</tr>
			
			
			<tr>
				<td>Guest Gender:</td>
				<td><input type="text" name="guestGender"/></td>
			</tr>
			
			<tr>
				<td>User Id:</td>
				<td><input type="number" name="user"/></td>
			</tr>
			
			<tr>
				<td>
					<a href="/login" class="button">Cancel</a>
					<input type="submit" value="Submit"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>