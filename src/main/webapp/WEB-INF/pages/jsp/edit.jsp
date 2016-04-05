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
        $("#edit").click(function(){
			var id=parseInt($('#id').val(),10);
            var number=parseInt($('#number').val(),10);
			var name=$('#name').val();
			var starttime=$('#starttime').val();
			var flighttime=$('#flighttime').val();
			var route={"fromPoint":"Samara",
						"toPoint":"Kinel"};

			var json={
                "id":id,
				"number":number,
				"planename":name,
				"starttime":starttime,
				"flighttime":flighttime,
				"route":route,

		};
			console.log(json);
			$.ajax({
				url:$('#form').attr("action"),
				cache: false,
				processData: false,
				dataType:"json",
				mimeType: 'application/json',
				contentType: 'application/json',
				data:JSON.stringify(json),
				type:"POST",
				headers: {
					'Accept': 'application/json',
					'Content-Type': 'application/json'
				},
				success:function(){
					$("#errorMsg").text("All right");
				},
				error:function(){
					$("#errorMsg").text("All wrong");
				}
			})
        });
    });

    </script>
	</head>
	<body>
		<div class="wrapper container">
		<header>
			<a href=""><img src="/resources/images/logo.png" alt="Netcracker Airlines"></a>
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
				<p id="errorMsg"></p>
				<form role="form" id="form" action="./saveFlight">
					<!--
					<div class="form-group">
						<label for="type">Type</label>
						<input type="type" class="form-control" id="type" placeholder="Type" value="$flight.TYPE}">
					</div>
					-->
					<input type="hidden" id="id" value="${flight.id}">
					<div class="form-group">
						<label for="number">Number</label>
						<input type="numbers" class="form-control" id="number" placeholder="Number" value="${flight.number}">
					</div>
					<div class="form-group">
						<label for="name">Plane Name</label>
						<input type="name" class="form-control" id="name" placeholder="Plane Name" value="${flight.planename}">
					</div>
					<div class="form-group">
						<label for="starttime">Start Time</label>
						<input type="starttime" class="form-control" id="starttime" placeholder="Start Time" value="${flight.starttime}">
					</div>
					<div class="form-group">
						<label for="flighttime">Flight Time</label>
						<input type="flighttime" class="form-control" id="flighttime" placeholder="Flight Time" value="${flight.flighttime}">
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

					</form>
				<button type="register" class="btn btn-success" id="edit">Register</button>
			</div>
		</div>
		</div>
	</body>
</html>