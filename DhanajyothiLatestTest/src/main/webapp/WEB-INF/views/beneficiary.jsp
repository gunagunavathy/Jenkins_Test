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
		<li class="logout"><a href="logout">LogOut</a></li>
	</ol>
	</nav>
	<div class="panel panel-primary" style="margin: 20px;">
		<div class="panel-heading">
			<h3 class="panel-title">Add Beneficiary</h3>
		</div>
		<div class="panel-body">
			<form:form action="savebeneficiary" method="post"
				modelAttribute="beneficiary">
				<div class="form-group row">
					<div class="col-md-4">
						<label for="beneficiaryNickName">Beneficiary Nick Name </label>
					</div>
					<div class="col-md-4">
						<label for="beneficiaryName">Beneficiary Name </label>
					</div>
					<div class="col-md-4">
						<label for="beneficiaryAccountNumber">Beneficiary Acc Num </label>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-4">
						<form:input path="beneficiaryNickName" />
						<br />
						<form:errors path="beneficiaryNickName" cssClass="error" />
					</div>
					<div class="col-md-4">
						<form:input path="beneficiaryName" />
						<br />
						<form:errors path="beneficiaryName" cssClass="error" />
					</div>
					<div class="col-md-4">
						<form:input path="beneficiaryAccountNumber" />
						<br />
						<form:errors path="beneficiaryAccountNumber" cssClass="error" />
					</div>
				</div>
				<c:if test="${not isTransferWithinBank}">
					<div class="form-group row">
						<div class="col-md-4">
							<label for="beneficiaryAccountNumber">Bank Name </label>
						
						</div>
						<div class="col-md-4">
							<label for="beneficiaryAccountNumber">IFSC Code </label>
						</div>
					</div>
				</c:if>
				<c:if test="${not isTransferWithinBank}">
					<div class="form-group row">
						<div class="col-md-4">
							<form:input path="beneficiaryBank" />
							<br />
							<form:errors path="beneficiaryBank" cssClass="error"/>
						
						</div>
						<div class="col-md-4">
							<form:input path="beneficiaryBankIfsc" />
							<br />
							<form:errors path="beneficiaryBankIfsc" cssClass="error" />
						</div>
					</div>
				</c:if>
				<div class="form-group row">
					<div class="col-md-4">
						<form:hidden path="beneficiaryType" />
						<br />
						<form:errors path="beneficiaryType" cssClass="error" />
					</div>
				</div>
				<div class="wrapper">
					<button type="reset" class="btn btn-warning">Reset</button>
					<button type="submit" class="btn btn-primary">Add</button>
				</div>

			</form:form>
		</div>
	</div>
</body>
</html>