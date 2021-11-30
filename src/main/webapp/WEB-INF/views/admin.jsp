<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<div class="container">
		<sec:authorize access="hasAuthority('admin')" >
			<ol>
				<li>Create RoomType table: <a href="${pageContext.request.contextPath}/getRoomTypeForm">click here</a></li>
				<li>Create AmenitiesHotel table: <a href="${pageContext.request.contextPath}/getAmenitiesHotelForm">click here</a></li>
				<li>Create AmenitiesRoom table: <a href="${pageContext.request.contextPath}/getAmenitiesRoomForm">click here</a></li>
				<li>Create Room table: <a href="${pageContext.request.contextPath}/getRoomForm">click here</a></li>
			</ol>
			<a href="${pageContext.request.contextPath}/home">Cancel</a>
		</sec:authorize>
		<sec:authorize access="!hasAuthority('admin')">
			<h3 align="center">Access Denied</h3>
			<jsp:include page='accessDenied.jsp'/><br>
		</sec:authorize>
	</div>

</body>
</html>