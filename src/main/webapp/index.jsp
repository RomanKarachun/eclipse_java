<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="TAXI CONTROL ROOM" scope="application" />

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
					 <th><a href="/ord"><i class="large material-icons">drag_handle</i></a></th>
                     <th><a href="ord?view=edit"><i class="large material-icons">add</i></a></th>
				     <th><a href="/car"><i class="large material-icons">list</i></a></th>
				     <th><a href="car?view=edit"><i class="large material-icons">group_add</i></a></th>
				     <th><a href="#"><i class="large material-icons">exit_to_app</i></a></th>
				</tr>
			</tbody>
			<tbody>
				<tr>					
				    <td>(Home page)</td>
					<td>(Database of orders)</td>
					<td>(Add/edit orders)</td>
					<td>(Database of cars)</td>
					<td>(Add/edit cars)</td>
					<td>(login/logout)</td>
					
				</tr>
		</table>
<div class="section no-pad-bot" id="index-banner">
	<div class="container">
		<div class="light-blue lighten-1"><h3 style="text-align: left;">📪 How to reach us:<br>
<br>GMAIL: romankarachun9@gmail.com<br>
<br>GH: github.com/RomanKarachun<br>
<br>Telegram: @romroom9
</h3>
</div>
</div>
</div>

</t:wrapper>
