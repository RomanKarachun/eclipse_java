<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<th>orderTime</th>
					<th>arrivalTime</th>
					<th>orderFinish</th>
					<th>actions</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${entity.id}</td>
					<td>${entity.clientName}</td>
					<td>${entity.carName}</td>
					<td>${entity.price}</td>
					<td>${entity.distance}</td>
					<td>${entity.arrivalTime}</td>
					<td>${entity.orderFinish}</td>
					<td><a class="btn-floating btn-large cyan pulse"  href="/ord?view=edit"><i class="material-icons">add</i></a>
				</tr>
			</tbody>
		</table>


</t:wrapper>

