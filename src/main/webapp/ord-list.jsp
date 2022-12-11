<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
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
					<th><mytaglib:sort-link pageUrl="${pageUrl}" column="id">ID</mytaglib:sort-link></th>
					<th>client name</th>
					<th>car name</th>
					<th><mytaglib:sort-link pageUrl="${pageUrl}" column="price">price</mytaglib:sort-link></th>
					<th><mytaglib:sort-link pageUrl="${pageUrl}" column="distance">distance</mytaglib:sort-link></th>
					<th><mytaglib:sort-link pageUrl="${pageUrl}" column="order_time">order time</mytaglib:sort-link></th>
<%-- 				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="arrival_time">arrival time</mytaglib:sort-link></th> --%>
<%-- 				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="order_finish">order finish</mytaglib:sort-link></th> --%>
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
<%-- 				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${entity.arrivalTime}" /></td> --%>
<%-- 				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${entity.orderFinish}" /></td> --%>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="/ord?view=edit&id=${entity.id}"><i
							class="material-icons">edit</i></a><a class="btn-small btn-floating waves-effect waves-light red" title="удалить" onclick="sendHTTPDelete('/ord?id=${entity.id}')"><i class="material-icons">delete</i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<t:paging />
</t:wrapper>

