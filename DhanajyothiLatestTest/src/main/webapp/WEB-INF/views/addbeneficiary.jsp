<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Beneficiary Page</title>
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
			<h3 class="panel-title">Select Beneficiary Type</h3>
		</div>
		<div class="panel-body">
			<div class="form-group row">
				<div class="col-md-6">
					<a href="beneficiarywithinbank">Transfer With In Bank</a>
				</div>
				<div class="col-md-6">
					<a href="beneficiaryotherbank">Transfer to Other Bank</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>