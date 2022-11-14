<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Edit data" scope="application" />

<t:wrapper>
		<h1>Edit order</h1>
		<div class="row">
			<form class="col s12">
				<div class="row">
					<div class="input-field col s4">
						<input number="Placeholder" id="â" type="text" class="validate"> <label for="â">â</label>
					</div>
					<div class="input-field col s4">
						<input id="driver_name" type="text" class="validate"> <label for="driver_name">Driver Name</label>
					</div>
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
				<form action="#">
			    <p>
			      <label>
			        <input type="checkbox" />
			        <span>Free?</span>
			      </label>
			    </p>
			      </form>
				<div class="row">

					
										<div class="input-field col s6">
						<input id="price" type="text" class="price"> <label for="price">Price</label>
				</div>
														<div class="input-field col s6">
						<input id="distance" type="text" class="distance"> <label for="price">Distance (km)</label>
				</div>

				</div>
				
								<div class="row">
					<div class="input-field col s4">
						<input id="type_of_order" type="text" class="validate"> <label for="type_of_order">Time of order</label>
					</div>
										<div class="input-field col s4">
						<input id="arrival_time" type="text" class="validate"> <label for="arrival_time">Arrival time</label>
					</div>
					<div class="input-field col s4">
						<input id="end_time" type="text" class="validate"> <label for="end_time">Finish of order</label>
					</div>

				</div>
				
				
				<div class="row">
					<div class="input-field col s12">
						<input id="password" type="password" class="validate"> <label for="password">Password</label>
					</div>
										<div class="input-field col s12">
						<input id="email" type="email" class="validate"> <label for="email">Email</label>
				</div>
				</div>
				<div class="row">
					<div class="col s12">
						This is an inline input field:
						<div class="input-field inline">
							<input id="email_inline" type="email" class="validate"> <label for="email_inline">Email</label> <span class="helper-text" data-error="wrong"
								data-success="right">Helper text</span>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="order.jsp"><i class="material-icons left">order</i>To order</a> <a class="btn waves-effect waves-light green"
					href="#"><i class="material-icons left">save</i>Save</a>
</div>
		</div>

</t:wrapper>

