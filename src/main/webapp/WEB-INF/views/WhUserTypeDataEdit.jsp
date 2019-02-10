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
	<h2>WELCOME TO WhUserType Updating page!!</h2>
	<form:form action="update" method="post" modelAttribute="whUserType">
		<pre>
		User Id:<form:input path="uid" readonly="true" />
User Type :<form:radiobutton path="userType" value="USER"
				disabled="true" /> User
		<form:radiobutton path="userType" value="VENDOR" disabled="true" /> Vendor
User Code:<form:input path="userCode" />
User For :<form:input path="userFor" />
User e-mail:<form:input path="userMail" />
User Contact :<form:input path="userContact" />
User ID Type:<form:select path="userIdType">
<form:option value="">-select-</form:option>
<form:option value="PANCARD">PanCard</form:option>
<form:option value="AADHARCARD">AdharCard</form:option>
<form:option value="VOTERCARD">VoterId</form:option>
<form:option value="OTHERS">others</form:option>
</form:select>
*If Other:<form:input path="otherType" />
ID Number :<form:input path="idNumber" />

<input type="submit" value="Update User" /> 
</pre>
	</form:form>
	<br> ${message}
</body>
</html>