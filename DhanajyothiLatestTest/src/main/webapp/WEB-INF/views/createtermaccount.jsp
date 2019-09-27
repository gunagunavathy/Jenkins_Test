<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Term Account</title>
<jsp:include page="header.jsp" />
</head>
<body>
	<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="accsummary">Account
				Summary</a></li>
		<li class="logout"><a href="logout">LogOut</a></li>
	</ol>
	</nav>
	<div class="panel panel-primary" style="margin: 20px;">
		<div class="panel-heading">
			<h3 class="panel-title">Term Account Creation</h3>
		</div>
		<div class="panel-body">
			<form:form action="createtermaccount" method="post"
				modelAttribute="account">
				<div class="form-group row">
					<div class="col-md-6">
						<label for="maturityAmount">Term Amount </label>
					</div>
					<div class="col-md-6">
						<label for="depositTenure">Tenure</label>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-6">
						<form:input path="maturityAmount" />
						<br />
						<form:errors path="maturityAmount" cssClass="error" />
					</div>
					<div class="col-md-6">
						<form:select path="depositTenure">
							<form:options items="${tenureList}" />
						</form:select>
						<br />
						<form:errors path="depositTenure" cssClass="error" />
					</div>
				</div>
				<div class="wrapper">
					<button type="reset" class="btn btn-warning">Reset</button>
					<button type="submit" class="btn btn-primary">Register</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>