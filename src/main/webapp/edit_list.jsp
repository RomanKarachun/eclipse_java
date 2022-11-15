<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Edit data" scope="application" />

<t:wrapper>
		<h1>Edit item</h1>
		<div class="row">
			<form class="col s12">
				<div class="row">
					<div class="input-field col s4">
						<input number="Placeholder"  type="text" class="validate"> <label for="â">â</label>
					</div>
					<div class="input-field col s4">
						<input id="driver_name" type="text" class="validate"> <label for="driver_name">Driver Name</label>
					</div>
									<div class="row">
					<div class="input-field col s4">
						<input car="car" id="car" type="text" class="validate"> <label for="car">Car</label>
					</div>
				</div>
                 <div class="row">
					<div class="input-field col s4">
						<input id="phone_name" type="text" class="validate"> <label for="phone_name">Phone number</label>
					</div>
						<div class="input-field col s4">
						<input comfort_level="comfort_level" id="comfort_level" type="text" class="validate"> <label for="comfort_level">Comfort level</label>
					</div>
					<div class="input-field col s4">
						<input id="number_of_seats" type="text" class="validate"> <label for="number_of_seats">Number of seats</label>
					</div>
				</div>

		<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="list.jsp"><i class="material-icons left">list</i>To list</a> <a class="btn waves-effect waves-light green"
					href="#"><i class="material-icons left">save</i>Save</a>
			</div>
		</div>
	</div>
	</form>
</div>

</t:wrapper>

