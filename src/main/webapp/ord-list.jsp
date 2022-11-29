<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Orders list" scope="application" />

<t:wrapper>

		<h1>Orders list</h1>
		<div class="row">
			<div class="col s12">
				<div class="center-align">
					<a class="btn-floating btn-large cyan pulse"  href="/ord?view=edit"><i class="material-icons">add</i></a>
				</div>
			</div>
		</div>
		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>client name</th>
					<th>car name</th>
					<th>price</th>
					<th>distance</th>
					<th>order time</th>
					<th>arrival time</th>
					<th>order finish</th>
					<th>actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="entity" items="${list}" varStatus="loopCounter">
				<tr>
					<td><c:out value="${entity.id}" /></td>
					<td><c:out value="${entity.clientName}" /></td>
					<td><c:out value="${entity.carName}" /></td>
					<td><c:out value="${entity.price}" /></td>
					<td><c:out value="${entity.distance}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${entity.orderTime}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${entity.arrivalTime}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${entity.orderFinish}" /></td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="/ord?view=edit&id=${entity.id}"><i
							class="material-icons">edit</i></a><a class="btn-small btn-floating waves-effect waves-light red" title="удалить" onclick="sendHTTPDelete('/ord?id=${entity.id}')"><i class="material-icons">delete</i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:wrapper>

