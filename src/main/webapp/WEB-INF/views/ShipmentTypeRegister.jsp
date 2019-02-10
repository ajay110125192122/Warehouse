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
				<h2>WELCOME TO SHIPMENT REGISTER PAGE</h2>
			</div>
			<div class="card-body">
				<form:form action="insert" method="post"
					modelAttribute="shipmentType">
					<div class="row">
						<div class="col-4">
							<label for="shipmentMode">SHIPMENT MODE</label>
						</div>
						<div class="col-6">
							<form:select path="shipmentMode">
								<form:option value="">-select-</form:option>
								<form:option value="AIR">Air</form:option>
								<form:option value="TRUCK">Truck</form:option>
								<form:option value="">Train</form:option>
								<form:option value="SHIP">Ship</form:option>
							</form:select>
						</div>
						<div class="row">
							<div class="col-4">
								<label for="shipmentCode">SHIPMENT CODE</label>
							</div>
							<div class="col-6">
								<form:input path="shipmentCode" />
							</div>
						</div>
						<div class="row">
							<div class="col-4">
								<label for="enbleShipment">ENABLE SHIPMENT</label>
							</div>
							<div class="col-6">
								<form:select path="enbleShipment">
									<form:option value="">-select-</form:option>
									<form:option value="YES">Yes</form:option>
									<form:option value="NO">No</form:option>
								</form:select>
							</div>
						</div>
						<div class="row">
							<div class="col-4">
								<label for="shipmentGrade">SHIPMENT GRADE</label>
							</div>
							<div class="col-6">
								<form:radiobutton path="shipmentGrade" value="A" />
								A
								<form:radiobutton path="shipmentGrade" value="B" />
								B
								<form:radiobutton path="shipmentGrade" value="C" />
								C
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="sdec">DESCRIPTION</label>
						</div>
						<div class="col-6">
							<form:textarea path="sdec" />
						</div>
						<div class="row">
							<div class="col-4"></div>
							<div class="col-6">
								<input class="btn btn-primary" type="submit"
									value="create Shipment" />
							</div>
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