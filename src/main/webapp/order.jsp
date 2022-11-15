<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Orders" scope="application" />

<t:wrapper>

		<h1>Orders list</h1>
		<div class="row">
			<div class="col s12">
				<div class="center-align">
					<a class="btn-floating btn-large cyan pulse"  title="edit" href="edit_order.jsp"><i class="material-icons">add</i></a>
				</div>
			</div>
		</div>
		<table>
			<thead>
				<tr>
					<th>â</th>
					<th>Driver name</th>
					<th>Car</th>
					<th>Phone number</th>
					<th>Comfort level</th>
					<th>Number of seats</th>
					<th>Free? (+/-)</th>
					<th>Price</th>
					<th>Distance (km)</th>
					<th>Time of order</th>
					<th>Arrival time</th>
					<th>Finish of order</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>7346 KH-4</td>
					<td>Egor Kunickiy</td>
					<td>Honda Civic</td>
					<td>+375299006555</td>
					<td>Comfort</td>
					<td>5</td>
					<td>+</td>
					<td>$0.87</td>
					<td>12 </td>
					<td>10:56 12.10.2022</td>
					<td>11:02 12.10.2022</td>
					<td>11:20 12.10.2022 </td>
					<td><a class="btn-floating btn-large cyan pulse"  title="edit" href="edit_order.jsp"><i class="material-icons">edit</i></a>
				</tr>
				<tr>
					<td>8546 HH-4</td>
					<td>Grigory Grib </td>
					<td>Volkswagen Polo</td>
					<td>+375332264862</td>
					<td>Economy</td>
					<td>4</td>
					<td>+</td>
					<td>$3.76</td>
					<td>10 </td>
					<td>11:00 12.10.2022</td>
					<td>11:02 12.10.2022</td>
					<td>11:18 12.10.2022 </td>
					<td><a class="btn-floating btn-large cyan pulse"  title="edit" href="edit_order.jsp"><i class="material-icons">edit</i></a>
				</tr>
				<tr>
					<td>7777 RG-7</td>
					<td>Rayan Gosling</td>
					<td>Ford Thunderbird</td>
					<td>+375447772689</td>
					<td>Kids</td>
					<td>5</td>
					<td>+</td>
					<td>$0.87</td>
					<td>5 </td>
					<td>10:57 12.10.2022</td>
					<td>11:05 12.10.2022</td>
					<td>11:15 12.10.2022 </td>
					<td><a class="btn-floating btn-large cyan pulse"  title="edit" href="edit_order.jsp"><i class="material-icons">edit</i></a>
				</tr>
			</tbody>
		</table>


</t:wrapper>

