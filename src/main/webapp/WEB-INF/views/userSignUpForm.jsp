<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>User Form</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">

</head>

<body>
	<form action="${pageContext.request.contextPath}/createUser" method="POST" >
		<table class="table table-dark">
			<tr><th colspan="3">User Login Credential</th></tr>
			<tr>
				<td>User Name: </td>
				<td><input type="text" name="username"/></td>
			</tr>
			
			<tr>
				<td>Password:</td>
				<td><input type="text" name="<your password>"/></td>
			</tr>
			
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"/></td>
			</tr>
			
			<tr>
				<td>Mobile:</td>
				<td><input type="text" name="mobile"/></td>
			</tr>
			
			<!-- <tr>
				<td>Role:</td>
				<td><input type="text" name="roles.roleName"/></td>
			</tr> -->
			
			<tr>
				<td>
					<a href="${pageContext.request.contextPath}/home" class="button">Cancel</a>
					<input type="submit" value="Submit"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>