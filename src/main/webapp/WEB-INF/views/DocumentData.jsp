<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to FileData</h2>
	<table border="1">

		<tr>
			<th>FID</th>
		</tr>
		<tr>
			<th>FNAME</th>
		</tr>
		<tr>
			<th>FDATA</th>
		</tr>
		<tr>
			<th>OPREATIONS</th>
		</tr>

		<c:forEach items="list" var="f">

			<tr>
				<c:out value="${f.fileId}"></c:out>
			</tr>
			<tr>
				<c:out value="${f.fileName}"></c:out>
			</tr>
			<tr>
				<c:out value="${f.fileData}"></c:out>
			</tr>


		</c:forEach>


	</table>

</body>
</html>