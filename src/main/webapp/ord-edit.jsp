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
					<div class="input-field col s3">
						<input type="text" name="clientId" value="${dto.clientId}"> <label for="clientId">Client ID</label>
					</div>
					<div class="input-field col s3">
						<input type="text" name="carId" value="${dto.carId}"> <label for="carName">Car ID</label>
					</div>
					<div class="input-field col s3">
						<input type="text" name="price" value="${dto.price}"> <label for="price">Price</label>
					</div>
					<div class="input-field col s3">
						<input type="text" name="distance" value="${dto.distance}"> <label for="distance">Distance</label>
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

