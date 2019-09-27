<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="doUpload" 
		enctype="multipart/form-data">
		<fieldset>
			<legend>File Upload</legend>
			<table border="0">
				<tr>
					<td>File1 :</td>
					<td><input type="file" name="fileUpload"/></td>
				</tr>
				<tr>
					<td>File2 :</td>
					<td><input type="file" name="fileUpload"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Upload"></td>
				</tr>
			</table>
		</fieldset>

	</form>


</body>
</html>