<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Edit order" scope="application" />

<t:wrapper>
		<h1>Edit order</h1>
		<div class="row">
			<form class="col s12">
				<div class="row">
					<div class="input-field col s3">
						<input type="text" class="validate"> <label for="id">id</label>
					</div>
					<div class="input-field col s3">
						<input type="text" class="validate"> <label for="client_id">Client Id</label>
					</div>
					<div class="input-field col s3">
						<input type="text" class="validate"> <label for="car_id">Car Id</label>
					</div>
					<div class="input-field col s3">
						<input type="text" class="validate"> <label for="price">Price</label>
					</div>
				
				
				<div class="row">
					<div class="input-field col s3">
						<input type="text" class="validate"> <label for="distance">Distance</label>
					</div>
					<div class="input-field col s3">
						<input type="text" class="validate"> <label for="order_time">Order Time</label>
					</div>
					<div class="input-field col s3">
						<input type="text" class="validate"> <label for="arrival_time">Arrival Time</label>
					</div>
					<div class="input-field col s3">
						<input type="text" class="validate"> <label for="order_finish">Order Finish</label>
					</div>
					</div>
				

		<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="order-list.jsp"><i class="material-icons left">order-list</i>To order-list</a> <a class="btn waves-effect waves-light green"
					href="#"><i class="material-icons left">save</i>Save</a>
			</div>
		</div>
	</div>
	</form>
</div>
</t:wrapper>

