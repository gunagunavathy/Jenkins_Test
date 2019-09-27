<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DhanJyothi Internet App</title>
<jsp:include page="header.jsp" />
<style type="text/css">
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<nav aria-label="breadcrumb">
  			<ol class="breadcrumb">
   			<li class="breadcrumb-item"><a href="login">Login</a></li>
  			</ol>
		</nav>
		
	<div class="panel panel-primary" style="margin: 20px;">
		<div class="panel-heading">
			<h3 class="panel-title">User Registration</h3>
		</div>
		<div class="panel-body">
	 		<form:form modelAttribute="user" action="save" method="post" enctype="multipart/form-data">
				<div class="form-group row">
						<div class="col-md-4">
							<label for="firstName">First Name </label>
						</div>
						<div class="col-md-4">
							<label for="lastName">Last Name</label>
						</div>
						<div class="col-md-4">
							<label for="dob">DOB </label>
						</div>
					</div>
				<div class="form-group row">
						<div class="col-md-4">
							<form:input type="text" path="firstName" /> <br />
							<form:errors path="firstName" cssClass="error"/>
						</div>
						<div class="col-md-4">
							<form:input type="text"  path="lastName"/> <br />
							<form:errors path="lastName" cssClass="error"/>
						</div>
						<div class="col-md-4">
							<form:input type="date"  path="dob"/> <br />
							<form:errors path="dob" cssClass="error"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-4">
							<label for="addressLine1">Address Line 1</label>
						</div>
						<div class="col-md-4">
							<label for="addressLine2">Address Line 2 </label>
						</div>
						<div class="col-md-4">
							<label for="city">City</label>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-4">
							<form:input type="text"  path="addressLine1"/> <br />
							<form:errors path="addressLine1" cssClass="error"/>
						</div>
						<div class="col-md-4">
							<form:input type="text"  path="addressLine2"/> <br />
							<form:errors path="addressLine2" cssClass="error"/>
						</div>
						<div class="col-md-4">
							<form:input type="text"  path="city"/> <br />
							<form:errors path="city" cssClass="error"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-4">
							<label for="state">State </label>
						</div>
						<div class="col-md-4">
							<label for="emailId">Pincode</label>
						</div>
						<div class="col-md-4">
							<label for="mobileNumber">Mobile Number </label>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-4">
							<form:input type="text"  path="state"/> <br />
							<form:errors path="state" cssClass="error"/>
						</div>
						<div class="col-md-4">
							<form:input type="text"  path="pin"/> <br />
							<form:errors path="pin" cssClass="error"/>
						</div>
						<div class="col-md-4">
							<form:input type="text"  path="mobileNumber"/> <br />
							<form:errors path="mobileNumber" cssClass="error"/>
						</div>
					</div>
					<div class="form-group row">
					    <div class="col-md-4">
							<label for="emailId">Email</label>
						</div>
						<div class="col-md-4">
							<label for="aadharId">Aadhar </label>
						</div>
						<div class="col-md-4">
							<label for="pan">Pan</label>
						</div>
					</div>
					<div class="form-group row">
					    <div class="col-md-4">
							<form:input type="text" path="emailId" /> <br />
							<form:errors path="emailId" cssClass="error"/>
						</div>
						<div class="col-md-4">
							<form:input type="text" path="aadharId" /> <br />
							<form:errors path="aadharId" cssClass="error"/>
						</div>
						<div class="col-md-4">
							<form:input type="text" path="pan" /> <br />
							<form:errors path="pan" cssClass="error"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-4">
							<label for="userName">Username </label>
						</div>
						<div class="col-md-4">
							<label for="password">Password</label>
						</div>
						<div class="col-md-4">
							<label for="confirmPassword">Confirm Password </label>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-4">
							<form:input type="text" path="userName" /> <br />
							<form:errors path="userName" cssClass="error"/>
						</div>
						<div class="col-md-4">
							<form:input type="password" path="password" /> <br />
							<form:errors path="password" cssClass="error"/>
						</div>
						<div class="col-md-4">
							<form:input type="password" path="confirmPassword" /> <br />
							<form:errors path="confirmPassword" cssClass="error"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-4">
							<label for="proofs">Date Of Birth Proof </label>
						</div>
						<div class="col-md-4">
							<form:input type="file" path="dobProof" accept="application/pdf,image/jpg,image/jpeg" /> <br />
							<form:errors path="dobProof" cssClass="error"/>
						</div>
						<div class="col-md-4">
							<label for="proofs">Ex: Passport,Birth Certificate Upload Oly PDF,JPG,JPEG Documents  </label>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-4">
							<label for="proofs">Address Proof</label>
						</div>
						<div class="col-md-4">
							<form:input type="file" path="addressProof" accept="application/pdf,image/jpg,image/jpeg"  /><br />
							<form:errors path="addressProof" cssClass="error"/>
						</div>
						<div class="col-md-4">
							<label for="proofs">Ex: License,Voter ID Upload Oly PDF,JPG,JPEG Documents  </label>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-4">
							<label for="proofs">Aadhar  </label>
						</div>
						<div class="col-md-4">
							<form:input type="file" path="aadharProof" accept="application/pdf,image/jpg,image/jpeg"  /><br />
							<form:errors path="aadharProof" cssClass="error"/>
						</div>
						<div class="col-md-4">
							<label for="proofs">Upload Oly PDF,JPG,JPEG Documents  </label>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-4">
							<label for="proofs">Pan  </label>
						</div>
						<div class="col-md-4">
							<form:input type="file" path="panProof" accept="application/pdf,image/jpg,image/jpeg"  /><br />
							<form:errors path="panProof" cssClass="error"/>
						</div>
						<div class="col-md-4">
							<label for="proofs">Upload Oly PDF,JPG,JPEG Documents  </label>
						</div>
					</div> 
							<div class="col-md-4">
							<form:input type="hidden" path="userStatus"/><br />
							<form:errors path="userStatus" cssClass="error"/>
						</div>
							<div class="col-md-4">
							<form:input type="hidden" path="userRole"/><br />
							<form:errors path="userRole" cssClass="error"/>
						</div>
					<div class="wrapper">
					<button type="reset" class="btn btn-warning">Reset</button>
					<button type="submit" class="btn btn-primary">Register</button>
					</div>
			</form:form>
		</div> 
</body>
</html>