<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="widht=device-width, initial-scale=1.0">
		<title>Main Page</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="/resources/css/style.css" rel="stylesheet">
		
		<script type="text/javascript">
		$(document).ready(function(){
        $("#btn").click(function(){
            $("#myModal").modal('show');
        });
    });

    </script>
	</head>
	<body>
		<div class="wrapper container">
		<header>
			<a href="/"><img src="./www/images/logo.png" alt="Netcracker Airlines"></a>
		</header>
		<div class="row middle">
			<div class="col-lg-4">
				<ul class="list-group submenu">
					<li class="list-group-item active"><a href="#">Main</a></li>
					<li class="list-group-item"><a href="#">Profile</a></li>
					<li class="list-group-item"><a href="#">Search</a></li>
					<li class="list-group-item"><a href="#">About</a></li>
				</ul>
			</div>
			<div class="col-lg-6 edit">
				<form role="form">
					<!--
					<div class="form-group">
						<label for="type">Type</label>
						<input type="type" class="form-control" id="type" placeholder="Type" value="$flight.TYPE}">
					</div>
					-->
					<div class="form-group">
						<label for="number">Number</label>
						<input type="numbers" class="form-control" id="number" placeholder="Number" value="${flight.number}">
					</div>
					<div class="form-group">
						<label for="name">Plane Name</label>
						<input type="name" class="form-control" id="name" placeholder="Plane Name" value="${flight.planeName}">
					</div>
					<div class="form-group">
						<label for="starttime">Start Time</label>
						<input type="starttime" class="form-control" id="starttime" placeholder="Start Time" value="${flight.startTime}">
					</div>
					<div class="form-group">
						<label for="flighttime">Flight Time</label>
						<input type="flighttime" class="form-control" id="flighttime" placeholder="Flight Time" value="${flight.flightTime}">
					</div>
					<div class="form-group">
						<label>Route</label>
							<select class="input-large">
								<option value="">Choose a Route</option>
								<option value="">Samara to Moscow</option>
								<option value="">Pestravka to Alakaevka</option>
								<option value="">Alakaevka to Samara</option>
							</select>
					</div>
						 <button type="register" class="btn btn-success">Register</button>
					</form>
			</div>
		</div>
		</div>
	</body>
</html>