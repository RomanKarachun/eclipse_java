<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Menu" scope="application" />

<t:wrapper>


	<div class="light-blue lighten-1"><h1 style="text-align: center;   color:white;">TAXI CONTROL ROOM</h1>		
	</div>
		<h4 style="text-align: center;"> <br>HI THERE!</h4>
		<h4 style="text-align: center;">CHOOSE YOUR OPTION:</h4>
		<div class="row">
			<div class="col s12">
				<div class="center-align">
					
				</div>
			</div>
		</div>
		<table>
			
			<tbody>
				<tr>
					<th><a href="index.jsp"><i class="large material-icons">home</i></a></th>
					 <th><a href="order.jsp"><i class="large material-icons">drag_handle</i></a></th>
                     <th><a href="edit_order.jsp"><i class="large material-icons">add</i></a></th>
				     <th><a href="list.jsp"><i class="large material-icons">list</i></a></th>
				     <th><a href="edit_list.jsp"><i class="large material-icons">group_add</i></a></th>
				     <th><a href="contact.jsp"><i class="large material-icons">contacts</i></a></th>
				     <th><a href="#"><i class="large material-icons">exit_to_app</i></a></th>
				</tr>
			</tbody>
			<tbody>
				<tr>					
				    <td>(Home page)</td>
					<td>(Orders changes)</td>
					<td>(Add/edit orders)</td>
					<td>(Database of drivers)</td>
					<td>(Add/edit drivers)</td>
					<td>(Contact details)</td>
					<td>(login/logout)</td>
					
				</tr>
		</table>

<p class="aligncenter"><img src="taxi.jpg" width="450" height="252"></p>
<style>
.aligncenter {
    text-align: center;
}
</style>

</t:wrapper>

