<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Edit order" scope="application" />
<t:wrapper>
	<c:choose>
		<c:when test="${empty dto.id}">
			<h1>Create order</h1>
		</c:when>
		<c:otherwise>
			<h1>Edit order #${dto.id}</h1>
		</c:otherwise>
	</c:choose>
	<form class="col s12" method="post" action="/ord">
		<div class="row">
		<input type="hidden" name="id" value="${dto.id}" />
				<div class="row">
					<div class="col s3">
					<label for="clientId">Client ID</label> 
					<select name="clientId" class="browser-default" required>
						<option value="">--select client--</option>
						<c:forEach items="${allClients}" var="client">
							<option value="${client.id}" <c:if test="${client.id eq dto.clientId}">selected="selected"</c:if>>${client.clientName}</option>
						</c:forEach>
					</select>
				</div>
					<div class="col s3">
					<label for="carId">Car ID</label> 
					<select name="carId" class="browser-default" required>
						<option value="">--select car--</option>
						<c:forEach items="${allCars}" var="car">
							<option value="${car.id}" <c:if test="${car.id eq dto.carId}">selected="selected"</c:if>>${car.carName}</option>
						</c:forEach>
					</select>
				</div>
					<div class="input-field col s3">
						<input type="number" name="price" required minlength=1 maxlength=5 value="${dto.price}"> <label for="price">Price</label>
					</div>
					<div class="input-field col s3">
						<input type="number" name="distance" required minlength=1 maxlength=5 value="${dto.distance}"> <label for="distance">Distance</label>
					</div>
					</div>

				
</div>
		<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="/ord"><i class="material-icons left">list</i>back</a>&nbsp;
				<button class="btn waves-effect waves-light" type="submit">
					<i class="material-icons left">save</i>save
				</button>
			</div>
		</div>
	</form>
</t:wrapper>

