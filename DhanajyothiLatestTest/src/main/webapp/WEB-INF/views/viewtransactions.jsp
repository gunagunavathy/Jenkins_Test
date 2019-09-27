<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Transactions</title>
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
			<h3 class="panel-title">Transactions</h3>
		</div>
		<div class="panel-body">
			<c:if test="${transactionsExists}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Transaction Id</th>
							<th scope="col">Transaction Description</th>
							<th scope="col">Transaction Amt</th>
							<th scope="col">Transaction Type</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${transactionsList}" var="transactions">
							<tr>
								<th scope="row">${transactions.transactionId}</th>
								<td>${transactions.transactionDescription}</td>
								<td>${transactions.transactionAmount}</td>
								<td>${transactions.transactionType}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${not  transactionsExists}">
				<p>Sorry You haven't performed any transactions</p>
			</c:if>
		</div>
	</div>
</body>
</html>