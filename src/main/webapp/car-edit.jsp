<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Edit cars" scope="application" />

<t:wrapper>
		<h1>Edit cars</h1>
		<div class="row">
			<form class="col s12">
				<div class="row">
					<div class="input-field col s4">
						<input type="text" class="validate"> <label for="id">id</label>
					</div>
					<div class="input-field col s4">
						<input type="text" class="validate"> <label for="car_name">Car Name</label>
					</div>
					<div class="input-field col s4">
						<input type="text" class="validate"> <label for="driver_id">Driver Id</label>
					</div>
				
				
				<div class="row">
					<div class="input-field col s4">
						<input type="text" class="validate"> <label for="comfort_level">Comfort Level</label>
					</div>
					<div class="input-field col s4">
						<input type="text" class="validate"> <label for="number_seats">Number Seats</label>
					</div>
					<div class="input-field col s4">
						<input type="text" class="validate"> <label for="free">Free</label>
					</div>
					</div>
				

		<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="car-list.jsp"><i class="material-icons left">car-list</i>To car-list</a> <a class="btn waves-effect waves-light green"
					href="#"><i class="material-icons left">save</i>Save</a>
			</div>
		</div>
	</div>
	</form>
</div>
</t:wrapper>
