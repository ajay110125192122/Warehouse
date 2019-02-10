<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to USER DATA page!!</h2>

	<a href="exportToExcelAll"> <img
		src="../resources/images/exportall.png">
	</a>
	<a href="exportToPdfAll"> <img src="../resources/images/pdf.png">
	</a>

	<table border="1">
		<tr>
			<th bgcolor="red">USERID</th>
			<th bgcolor="red">USERNAME</th>
			<th bgcolor="red">USERMAIL</th>
			<th bgcolor="red">U_ROLES</th>
			<th bgcolor="red">CONTACT</th>

			<th bgcolor="red" colspan="7">OPERATIONS</th>
		</tr>
		<c:forEach items="${list}" var="u">
			<tr>
				<td bgcolor="skyblue"><c:out value="${u.userid}"></c:out></td>
				<td bgcolor="skyblue"><c:out value="${u.userName}"></c:out></td>
				<td bgcolor="skyblue"><c:out value="${u.userMail}"></c:out></td>
				<td bgcolor="skyblue"><c:out value="${u.roles}"></c:out></td>
				<td bgcolor="skyblue"><c:out value="${u.mobile}"></c:out></td>

				<td bgcolor="skyblue"><a href="delete?id=${u.userid}"><img
						src="../resources/images/Delete.png" height="25" width="25" /></a></td>
				<td bgcolor="skyblue"><a href="viewOne?id=${u.userid}"><img
						src="../resources/images/viewall.png" height="25" width="25" /></a></td>
				<td bgcolor="skyblue"><a href="editOne?id=${u.userid}"><img
						src="../resources/images/Edit.png" height="25" width="25" /></a></td>

				<td bgcolor="skyblue"><a href="exportExcelOne?id=${u.userid}"><img
						src="../resources/images/excel.png" height="30" width="30" /></a></td>
				<td bgcolor="skyblue"><a href="exportPdfOne?id=${u.userid}"><img
						src="../resources/images/pdf.png" height="30" width="30" /></a></td>


			</tr>
		</c:forEach>
	</table>
	${message}
</body>
</html>