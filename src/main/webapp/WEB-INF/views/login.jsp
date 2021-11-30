 <%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login Page</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
</head>
<body>
<div align="center">

<p>
<h3>Login Form </h3>
<c:if test="${not empty errorMessage}" >
	${errorMessage}
</c:if>

<form name="login"  action="/login" method="POST">
	<table>
		<tr>
			<td> User Name:</td>
			<td> <input type="text" name="username" /> </td>
		</tr>
		
		<tr>
			<td>Password:</td>
			<td> <input type="<your password>" name="<your password>" /> </td>
		</tr>
		
		<tr>		
			<td colspan="2" align="center"> 
			<input type="submit" name="submit"  value="Login"  class="btn btn-primary"/> 
			</td>
		</tr>		
	</table>
	<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
	<!-- 
	csrf = cross site resource forgery 
	When you use  spring form, there is no need to use csrf parameters becuase spring generates them for you.
	-->
	
</form>
</div>
</body>
</html>  --%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login Page</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<p>${Message}</p>
<div align="center">
<form action="/login" method="POST">
<table>
<tr>
<td>UserName</td><td><input type="text" name="username" required="required"></td>
</tr>
<tr>
<td>Password</td><td><input type="<your password>" name="<your password>" required="required"></td>
</tr>

<td>&nbsp;</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" name="submit" id="loginSubmit" value="LogIn" class="btn btn-primary"></td>
</tr>

<tr>
<td>&nbsp;</td>
</tr>
<tr>
<td colspan="2" align="center"><a href="/getUserSignUpForm">Create Account</a></td>
</tr>

</table>
</form>
</div>


</body>
</html>