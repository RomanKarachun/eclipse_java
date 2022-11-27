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
					<th>id</th>
					<th>car name</th>
					<th>driver name</th>
					<th>comfort level</th>
					<th>number seats</th>
					<th>free</th>
					<th>actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="entity" items="${list}" varStatus="loopCounter">
				<tr>
					<td><c:out value="${entity.id}" /></td>
					<td><c:out value="${entity.carName}" /></td>
					<td><c:out value="${entity.driverName}" /></td>
					<td><c:out value="${entity.comfortLevel}" /></td>
					<td><c:out value="${entity.numberSeats}" /></td>
					<td><c:out value="${entity.free}" /></td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="/car?view=edit&id=${entity.id}"><i
							class="material-icons">edit</i></a><a class="btn-small btn-floating waves-effect waves-light red" title="удалить" onclick="sendHTTPDelete('/car?id=${entity.id}')"><i class="material-icons">delete</i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:wrapper>

