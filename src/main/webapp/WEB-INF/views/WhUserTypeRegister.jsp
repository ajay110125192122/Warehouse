<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">

		<div class="card">

			<div class="card-header bg-info text-white">
				<h2>WELCOME TO WH_USER REGISTER PAGE</h2>
			</div>
			<div class="card-body">
				<form:form action="insert" method="post" modelAttribute="whUserType">
					<div class="row">
						<div class="col-4">
							<label for="userType">USER TYPE</label>
						</div>
						<div class="col-6">
							<form:radiobutton path="userType" value="USER" />
							User
							<form:radiobutton path="userType" value="VENDOR" />
							Vendor
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for=userCode>USER CODE</label>
						</div>
						<div class="col-6">
							<form:input path="userCode" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="userFor">USER FOR</label>
						</div>
						<div class="col-6">
							<form:input path="userFor" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="userMail">USER E-MAIL</label>
						</div>
						<div class="col-6">
							<form:input path="userMail" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="userContact">USER CONTACT</label>
						</div>
						<div class="col-6">
							<form:input path="userContact" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="userIdType">USER ID TYPE</label>
						</div>
						<div class="col-6">
							<form:select path="userIdType">
								<form:option value="">-select-</form:option>
								<form:option value="PANCARD">PanCard</form:option>
								<form:option value="AADHARCARD">AdharCard</form:option>
								<form:option value="VOTERCARD">VoterId</form:option>
								<form:option value="OTHERS">others</form:option>
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="otherType">*IF OTHER</label>
						</div>
						<div class="col-6">
							<form:input path="otherType" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="idNumber">ID NUMBER</label>
						</div>
						<div class="col-6">
							<form:input path="idNumber" />
						</div>
					</div>
					<div class="row">
						<div class="col-4"></div>
						<div class="col-6">
							<input class="btn btn-primary" type="submit" value="Register" />
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<c:if test="${message != null }">
		<div class="card-footer bg-success text-white">${message}</div>
	</c:if>
</body>
</html>