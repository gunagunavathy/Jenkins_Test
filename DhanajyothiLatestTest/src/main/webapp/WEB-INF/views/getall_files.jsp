<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Files</h1>
	<table align="center" border="1">
		<tr>
			<th>File Id</th>
			<th>File Name</th>
		</tr>
		<c:forEach items="${li}" var="l">
			<tr>
				<td>${l.id}</td>
				<td><a href="doDownload/fileName=${l.fileName}">${l.fileName}</td></a>
			</tr>
		</c:forEach>
	</table>
</body>
</html>