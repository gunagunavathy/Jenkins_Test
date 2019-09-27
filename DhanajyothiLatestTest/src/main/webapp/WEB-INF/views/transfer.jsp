<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer Page</title>
<jsp:include page="header.jsp" />
</head>
<body>
	<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="accsummary">Account
				Summary</a></li>
		<li class="breadcrumb-item"><a href="loadbeneficiary">Add
				Beneficiary</a></li>
		<li class="logout"><a href="logout">LogOut</a></li>
	</ol>
	</nav>
	<div class="panel panel-primary" style="margin: 20px;">
		<div class="panel-heading">
			<h3 class="panel-title">Fund Transfer</h3>
		</div>
		<div class="panel-body">
			<form:form action="transferamt" method="post"
				modelAttribute="transaction">
				<div class="form-group row">
					<div class="col-md-4">
						<label for="benificiary">Beneficiaries </label>

					</div>
					<div class="col-md-4">
						<label for="transactionAmount">Amount </label>
					</div>
					<div class="col-md-4">
						<label for="transactionDescription">Remarks </label>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-4">
						<form:select path="benificiary.beneficiaryId">
							<form:options items="${beneficiariesList}" itemValue="beneficiaryId"
								itemLabel="beneficiaryNickName" />
						</form:select>

					</div>
					<div class="col-md-4">
						<form:input path="transactionAmount" />
						<br />
						<form:errors path="transactionAmount" cssClass="error" />
					</div>
					<div class="col-md-4">
						<form:input path="transactionDescription" />
						<br />
						<form:errors path="transactionDescription" cssClass="error" />
					</div>
				</div>
				<div class="wrapper">
					<button type="reset" class="btn btn-warning">Reset</button>
					<button type="submit" class="btn btn-primary">Transfer</button>
				</div>
		</div>
	</div>
	</form:form>
</body>
</html>