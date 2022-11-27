<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Cars list" scope="application" />

<t:wrapper>

		<h1>Cars list</h1>
		<div class="row">
			<div class="col s12">
				<div class="center-align">
					<a class="btn-floating btn-large cyan pulse"  href="/car?view=edit"><i class="material-icons">add</i></a>
				</div>
			</div>
		</div>
		<table>
			<thead>
				<tr>
					<th>№</th>
					<th>Driver name</th>
					<th>Car</th>
					<th>Phone number</th>
					<th>Comfort level</th>
					<th>Number of seats</th>
					<th>Free</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="entity" items="${list}" varStatus="loopCounter">
				<tr>
					<td><c:out value="${entity.id}" /></td>
					<td><c:out value="${entity.driverName}" /></td>
					<td><c:out value="${entity.Car}" /></td>
					<td><c:out value="${entity.phoneNumber}" /></td>
					<td><c:out value="${entity.comfortLevel}" /></td>
					<td><c:out value="${entity.numberSea}" /></td>
					<td><c:out value="${entity.free}" /></td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="/car?view=edit&id=${entity.id}"><i
							class="material-icons">edit</i></a><a class="btn-small btn-floating waves-effect waves-light red" title="удалить" onclick="sendHTTPDelete('/car?id=${entity.id}')"><i class="material-icons">delete</i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</t:wrapper>

