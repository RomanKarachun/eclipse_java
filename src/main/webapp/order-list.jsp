<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Orders list" scope="application" />

<t:wrapper>

		<h1>Orders list</h1>
		<div class="row">
			<div class="col s12">
				<div class="center-align">
					<a class="btn-floating btn-large cyan pulse"  title="edit" href="order-edit.jsp"><i class="material-icons">add</i></a>
				</div>
			</div>
		</div>
		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>client</th>
					<th>car</th>
					<th>price</th>
					<th>distance</th>
					<th>order time</th>
					<th>arrival time</th>
					<th>order finish</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>7346</td>
					<td>Karachun Roman</td>
					<td>Honda Civic</td>
					<td>$0.87</td>
					<td>12</td>
					<td>10:56 12.10.2022</td>
					<td>11:02 12.10.2022</td>
					<td>11:20 12.10.2022 </td>
					<td><a class="btn-floating btn-large cyan pulse"  title="edit" href="order-edit.jsp"><i class="material-icons">edit</i></a>
				</tr>
			</tbody>
		</table>


</t:wrapper>

