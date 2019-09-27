<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Summary</title>
<jsp:include page="header.jsp" />
</head>
<body>
	<nav aria-label="breadcrumb">
  			<ol class="breadcrumb">
   			<li class="breadcrumb-item">Welcome ${userName}</li>
   			<li class="logout"><a href="logout">LogOut</a></li>
  			</ol>
	</nav>
	<div class="panel panel-primary" style="margin: 20px;">
	<div class="panel-heading">
			<h3 class="panel-title">Admin Summary</h3>
		</div>
	</div>
	
</body>
</html>