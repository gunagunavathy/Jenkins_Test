<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
	<form:form action="upload" modelAttribute="uploadfile"
		enctype="multipart/form-data" method="post">
		<table border="0">
			<tr>
				<td>Upload File</td>
				<td><form:input type="file" path="file" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Upload"></td>
			</tr>


		</table>

	</form:form>

</body>
</html>