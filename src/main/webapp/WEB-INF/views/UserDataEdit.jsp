<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome To USER RegisterPage!!</h1>
	<form:form action="update" method="post" modelAttribute="user">
		<pre>
		ID :<form:input path="userid" readonly="true"/>
NAME:<form:input path="userName" />
E-Mail :<form:input path="userMail" />
PASSWORD: <form:password path="pwd" readonly="true" />
MOBILE:<form:input path="mobile" />
ROLES:<form:checkbox path="roles" value="ADMIN" />Admin
		<form:checkbox path="roles" value="APP_USER" />App-User
<input type="submit" value="UPDATE" />


</pre>

	</form:form>
${message}
<br/>
<a href="all"> <img src="../resources/images/viewall.png"/></a>


</body>
</html>