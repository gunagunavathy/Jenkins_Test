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
			<h3 class="panel-title">Account Summary</h3>
		</div>
	<div class="panel-body">
		<ul class="nav nav-tabs">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Account <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><c:if test="${not isSavingsAccountExists}">
							<li><a href="createsavingsaccount">Create Savings Account</a></li>
						</c:if> <c:if test="${isSavingsAccountExists}">
							<li><a href="loadtermaccount">Create Term Account</a></li>
						</c:if>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Funds Transfer <span
					class="caret"></span></a>
				<ul class="dropdown-menu">
				    <c:if test="${isSavingsAccountExists}">
							<li><a href="loadbeneficiary">Add Beneficiary</a></li>
							<li><a href="loadtransfer">Fund Transfer</a></li>
					</c:if>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Others <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Check Book Request</a></li>
				</ul></li>
		</ul>
		<br>
		<c:if test="${not  isSavingsAccountExists}">
			<p>Kindly Create your Savings Account</p>
		</c:if>
		<c:if test="${isSavingsAccountExists}">
			<h2>Savings Account Details</h2>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Account Number</th>
						<th scope="col">Account Type</th>
						<th scope="col">Account Balance</th>
						<th scope="col">Created Date</th>
						<th scope="col">Updated Date</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">${savingsaccount.accountId}</th>
						<td>${savingsaccount.accountType}</td>
						<td>${savingsaccount.accountBalance}</td>
						<td>${savingsaccount.accountCreatedDate}</td>
						<td>${savingsaccount.accountUpdatedDate}</td>
						<td><a href="viewtransactions">View</a></td>
					</tr>
				</tbody>
			</table>
		</c:if>
		<c:if test="${isTermAccountExists}">
			<h2>Term Account Details</h2>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Account Number</th>
						<th scope="col">Account Type</th>
						<th scope="col">Term AMT</th>
						<th scope="col">Term Tenure</th>
						<th scope="col">Interest</th>
						<th scope="col">Mature Date</th>
						<th scope="col">Created Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${termaccount}" var="term">
						<tr>
							<th scope="row">${term.accountId}</th>
							<td>${term.accountType}</td>
							<td>${term.maturityAmount}</td>
							<td>${term.depositTenure}</td>
							<td>${term.interestRate}</td>
							<td>${term.accountCreatedDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	</div>
</body>
</html>