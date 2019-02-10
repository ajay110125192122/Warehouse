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
			<div class="card-header bg-primary text-white">
				<h2>ORDER METHOD REGISTER PAGE</h2>
			</div>
			<div class="Container-body text-white">
				<form:form action="insert" method="post"
					modelAttribute="orderMethod">
					<div class="row">
						<div class="col-4">
							<label for="orderMode">ORDER MODE</label>
						</div>
						<div class="col-6">
							<form:radiobutton path="orderMode" value="SALE" />
							Sale
							<form:radiobutton path="orderMode" value="PURCHASE" />
							Purchase
						</div>
						<form:errors path="orderMode" />
					</div>
					<div class="row">
						<div class="col-4">
							<label for="orderCode">ORDER CODE</label>
						</div>
						<div class="col-6">
							<form:input path="orderCode" cssClass="form-control" />
						</div>
						<form:errors path="orderCode" />
					</div>
					<div class="row">
						<div class="col-4">
							<label for="exeType">EXECUTE TYPE</label>
						</div>
						<div class="col-6">
							<form:select path="exeType">
								<form:option value="">-select-</form:option>
								<form:option value="FIFO">FIFO</form:option>
								<form:option value="LIFO">LIFO</form:option>
								<form:option value="FCFO">FCFO</form:option>
								<form:option value="FEFO">FEFO</form:option>
							</form:select>
						</div>
						<form:errors path="exeType" />
					</div>
					<div class="row">
						<div class="col-4">
							<label for="orderAccept">ORDER ACCEPT</label>
						</div>
						<div class="col-6">
							<form:checkbox path="orderAccept" value="Multi-Model" />
							Multi-Model
							<form:checkbox path="orderAccept" value="Accept Return" />
							Accept Return
							<form:checkbox path="orderAccept" value="Service Extend" />
							Service Extend
						</div>
						<form:errors path="orderAccept" />
					</div>
					<div class="row">
						<div class="col-4">
							<label for="sDsc">DESCRIPTION</label>
						</div>
						<div class="col-6">
							<form:textarea path="sDsc" cssClass="form-control" />
						</div>
						<form:errors path="sDsc" />
					</div>
					<div class="row">
						<div class="col-4"></div>
						<div class="col-6">
							<input class="btn btn-primary" type="submit" value="createOrder" />
						</div>
					</div>
				</form:form>
			</div>
			<c:if test="${message != null }">
				<div class="card-footer bg-success text-white">${message}</div>
			</c:if>
		</div>
	</div>
</body>
</html>