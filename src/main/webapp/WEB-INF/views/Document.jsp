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
	<h1>Welcome to File Upload Page</h1>
	<form action="upload" method="post" enctype="multipart/form-data">
		<pre>

UPLOAD :: <input type="file" name="multipartFile" />
<input type="submit" value="Upload" />



</pre>
	</form>
	<br />
	<pre>
	<table border="1">

		<tr bgcolor="pink">
			<th>FID</th>
			<th>FNAME</th>
			<th>OPTIONS</th>
		</tr>

		<c:forEach items="${list}" var="f">

			<tr bgcolor="pink">
				<td bgcolor="Aquamarine"><c:out value="${f[0]}"></c:out></td>
			
				<td bgcolor="Aquamarine"><c:out value="${f[1]}"></c:out></td>
				<td bgcolor="Aquamarine"><a href="download?docId=${f[0]}"><img
							src="../resources/images/download.png" height="30" width="40" /></a></td>
			</tr>
			<%-- <tr>
				<td><c:out value="${f[2]}"></c:out></td>
			</tr> --%>
			
		</c:forEach>
		
	</table>
</pre>
	<br /> ${message}
	<br />
	<a href="all">VIEWALL</a>

</body>
</html>