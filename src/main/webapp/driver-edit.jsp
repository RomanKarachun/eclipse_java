<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Edit drivers" scope="application" />
<t:wrapper>
	<c:choose>
		<c:when test="${empty dto.id}">
			<h1>Create driver</h1>
		</c:when>
		<c:otherwise>
			<h1>Edit driver #${dto.id}</h1>
		</c:otherwise>
	</c:choose>
	<form class="col s12" method="post" action="/driver">
		<div class="row">
		<input type="hidden" name="id" value="${dto.id}" />
				<div class="row">
					<div class="input-field col s6">
						<input type="text" name="driverName" required minlength=1 maxlength=50 value="${dto.driverName}"> <label for="driverName">Driver Name</label>
					</div>
					<div class="input-field col s6">
						<input type="text" name="phoneNumber" required minlength=12 maxlength=12 value="${dto.phoneNumber}"> <label for="phoneNumber">Phone Number</label>
					</div>
				
				</div>
		</div>
		<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="/driver"><i class="material-icons left">list</i>back</a>&nbsp;
				<button class="btn waves-effect waves-light" type="submit">
					<i class="material-icons left">save</i>save
				</button>
			</div>
		</div>
	</form>
</t:wrapper>
