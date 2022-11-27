<%@tag description="Page template" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title><c:out value="${pageTitle}" /></title>

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="/css/styles.css" rel="stylesheet">

</head>


<nav class="light-blue lighten-1" role="navigation">
	<div class="nav-wrapper container">
		<a id="logo-container" href="" class="brand-logo">TCM</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a href="index.jsp"><i class="large material-icons">home</i></a></li>
			<li><a href="/ord"><i class="large material-icons">drag_handle</i></a></li>
			<li><a href="ord?view=edit"><i class="large material-icons">add</i></a></li>
			<li><a href="car"><i class="large material-icons">menu</i></a></li>
			<li><a href="car?view=edit"><i class="large material-icons">group_add</i></a></li>
			<li><a href="#"><i class="large material-icons">exit_to_app</i></a></li>
			<li><a href="#">
			</a></li>
		</ul>
	</div>
</nav>

<div class="section no-pad-bot" id="index-banner">
	<div class="container">
		<jsp:doBody />
		<!-- Page body will be here -->
	</div>
</div>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>
