<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer List</title>
</head>
<body bgcolor="orange">
<h1>Customers</h1>
	<table align="center" border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Date Of Birth</th>
			<th>Address Line1</th>
			<th>Address Line2</th>
			<th>City</th>
			<th>State</th>
			<th>Pin</th>
			<th>Mobile Number</th>
			<th>Email</th>
			<th>Aadhar</th>
			<th>Pan</th>
			<th>User Name</th>
			<th>Password</th>
		</tr>
		<c:forEach items="${customers}" var="cus">
			<tr>
				<td>${cus.firstName}</td>
				<td>${cus.lastName}</td>
				<td>${cus.dateOfBirth}</td>
				<td>${cus.addressLine1}</td>
				<td>${cus.addressLine2}</td>
				<td>${cus.city}</td>
				<td>${cus.state}</td>
				<td>${cus.pin}</td>
				<td>${cus.mobileNumber}</td>
				<td>${cus.email}</td>
				<td>${cus.aadhar}</td>
				<td>${cus.pan}</td>
				<td>${cus.userName}</td>
				<td>${cus.password}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="login">Login</a>
</body>
</html>