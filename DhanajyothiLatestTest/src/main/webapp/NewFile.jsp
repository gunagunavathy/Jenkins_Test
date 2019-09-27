<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	
</script>
<script type="text/javascript" src="jquery-1.3.2.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#transaction-bank-form").hide();
		$("#transaction-form").hide();
		$("#test").hide();
		$("#next-page").click(function() {
			var value = $("input[name='bank']:checked").val();
			if (value == 'bank') {
				$("#withbank").val("bank");
				$("#transaction-bank-form").show();
				$("#transaction-form").hide();
				$("#bank").hide();
			} else {
				$("#transaction-bank-form").hide();
				$("#with-other-bank").val("bank");
				$("#transaction-form").show();
				$("#bank").hide();
			}

		});
		/* $("#show").on('click', function() {
			//var value = $("input[name='test1']:selected").val();
			$("#testing").val(value);
			$("#test").show();
		}); */
		$("#isSelect").on('change', function() {

			var value = $("#isSelect").val();
			//alert(value);
			var res = value.split(",");
			$("#accountno").val(res[0]);
			$("#accounttype").val(res[1]);
			$("#test").show();

		});

		function displayuser() {
			document.getElementById("testing").value = "testing";
		}
		//withotherbank
		$("#withotherbank").on('change', function() {
			var value = $("#withotherbank").val();
			var res = value.split(",");
			$("#accountno").val(res[0]);
			$("#accounttype").val(res[1]);
			$("#with-other-bank").show();

		});

	});
</script>
</head>
<body>
	<div class="bs-example">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<div class="container-fluid">
					<h3>
						<center>
							<a href="dashboard">Home</a><label>/</label><a
								href="fundtransfer">Add Transaction</a>
						</center>
					</h3>
				</div>
			</div>
		</div>

		<div class="panel panel-body">

			<div align="center" id="bank">
				<h4>
					With Bank: <input type="radio" name="bank" value="bank" /> With
					other Bank: <input type="radio" name="bank" value="otherbank" />
				</h4>
				<input type="button" value="next" id="next-page"
					class="btn btn-info">
			</div>
			<div id="transaction-bank-form">
				<form:form action="saveTransaction" modelAttribute="transaction">
					<div class="form-group">
						<label for="accountno">User Account </label> <br> <br> <input
							type="text" value="${user.id}" class="form-control"
							disabled="true" />
					</div>
					<div class="form-group">
						<label for="lastName"> Beneficiary:</label> <br> <br>
						<form:select path="benname" id="isSelect" class="form-control">
							<form:option value="NONE" label="--- Select ---" />
							<c:forEach items="${withbank}" var="beneficiary">
								<form:option
									value="${beneficiary.accountno},${beneficiary.accounttype}"
									label="${beneficiary.name}" />

							</c:forEach>
						</form:select>
						<div id="test">
							<p>
								Accountno:<input type="text" id="accountno" disabled="true" />
								Account type:<input type="text" id="accounttype" disabled="true" />
							</p>
						</div>
					</div>
					<div class="form-group">
						<label for="remarks"> Description:</label> <br> <br>
						<form:input path="remarks" class="form-control"></form:input>
					</div>
					<div class="form-group">
						<label for="amount">Amount</label> <br> <br>
						<form:input path="amount" class="form-control"></form:input>
					</div>
					<input type="submit" value="submit" class="btn btn-success">
					<form:hidden path="bank" id="withbank" />
				</form:form>
			</div>

			<div id="transaction-form">
				<form:form action="saveTransaction" modelAttribute="transaction">
					<p>other bank</p>
					<div class="form-group">
						<label for="accountno">User Account </label> <br> <br> <input
							type="text" value="${user.id}" class="form-control"
							disabled="true" />
					</div>
					<div class="form-group">
						<label for="lastName"> Beneficiary:</label> <br> <br>
						<form:select path="benname" id="withotherbank">
							<option label="--- Select ---" />
							<c:forEach items="${with_other_bank}" var="beneficiary">
								<form:option
									value="${beneficiary.accountno},${beneficiary.accounttype}"
									label="${beneficiary.name}" id="${beneficiary.accounttype}" />
							</c:forEach>
						</form:select>
						<div id="with-other-bank">
							<p>
								Accountno:<input type="text" id="accountno" disabled="true" />
								Account type:<input type="text" id="accounttype" disabled="true" />
							</p>
						</div>
					</div>
					<p id="testing"></p>
					<div class="form-group">
						<label for="remarks"> Description:</label> <br> <br>
						<form:input path="remarks" class="form-control"></form:input>
					</div>
					<div class="form-group">
						<label for="amount">Amount</label> <br> <br>
						<form:input path="amount" class="form-control"></form:input>
					</div>
					<input type="submit" value="submit" class="btn btn-success">
					<form:hidden path="bank" id="with-other-bank" />
				</form:form>

			</div>

		</div>

	</div>
</body>
</html>