<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Edit cars" scope="application" />
<t:wrapper>
	<c:choose>
		<c:when test="${empty dto.id}">
			<h1>Create car</h1>
		</c:when>
		<c:otherwise>
			<h1>Edit car #${dto.id}</h1>
		</c:otherwise>
	</c:choose>
	<form class="col s12" method="post" action="/car">
		<div class="row">
		<input type="hidden" name="id" value="${dto.id}" />
				<div class="row">
					<div class="input-field col s6">
						<input type="text" name="carName" required minlength=1 maxlength=50 value="${dto.carName}"> <label for="carName">Car Name</label>
					</div>
					<div class="col s6">
					<label for="driverId">Driver ID</label> 
					<select name="driverId" class="browser-default" required>
						<option value="">--select driver--</option>
						<c:forEach items="${allDrivers}" var="driver">
							<option value="${driver.id}" <c:if test="${driver.id eq dto.driverId}">selected="selected"</c:if>>${driver.driverName}</option>
						</c:forEach>
					</select>
				</div>
				
				</div>
				<div class="row">
					<div class="input-field col s4">
						<input type="text" name="comfortLevel" required minlength=1 maxlength=10 value="${dto.comfortLevel}"> <label for="comfortLevel">Comfort Level</label>
					</div>
					<div class="input-field col s4">
						<input type="number" name="numberSeats" required minlength=1 maxlength=2 value="${dto.numberSeats}"> <label for="numberSeats">Number Seats</label>
					</div>
					<div class="input-field col s4">
						<label><input type="checkbox" name="free" ${dto.free ? 'checked' : ''} required value="true" /> <span>Free</span></label>
					</div>
					</div>
				

		</div>
		<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="/car"><i class="material-icons left">list</i>back</a>&nbsp;
				<button class="btn waves-effect waves-light" type="submit">
					<i class="material-icons left">save</i>save
				</button>
			</div>
		</div>
	</form>
</t:wrapper>
