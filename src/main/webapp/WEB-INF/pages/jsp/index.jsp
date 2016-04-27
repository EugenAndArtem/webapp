<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="widht=device-width, initial-scale=1.0">
		<title>Main Page</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#delete_link").click(function(){
					var id=parseInt($(this).attr('number'),10);
					$.ajax({
						url:"./deleteFlight",
						data:id,
						cache: false,
						processData: false,
						contentType: 'text/html',
						type:"GET",
						headers: {
							'Accept': 'text/html',
							'Content-Type': 'text/html'
						},
						success:function(response){
							console.log(response.responsetext);
							console.log("Delete Success");
						},
						error:function(){
							console.log("Something wrong");
						}
					})
				});
			});

		</script>
		<link href="/resources/css/style.css" rel="stylesheet">

	</head>
	<body>
		<div class="wrapper container">
		<header>
			<a href="/"><img src="/resources/images/logo.png" alt="Netcracker Airlines"></a>
		</header>
		<div class="row middle" >
			<div class="col-lg-4">
				<ul class="list-group submenu">
					<li class="list-group-item active"><a href="#">Main</a></li>
					<li class="list-group-item"><a href="#">Profile</a></li>
					<li class="list-group-item"><a href="#">Search</a></li>
					<li class="list-group-item"><a href="#">About</a></li>
				</ul>
			</div>
			<div class="col-lg-6" ng-app="flightsApp" ng-controller="flightsController">
				<table class="table">
				<thead>
				<tr>
					<th>№</th>
					<th>Flight</th>
				<tr>
				</thead>
				<tbody>
				<!--<c:forEach items="${flights}" var="flight">-->
					<tr ng-repeat="flight in flights">
						<td>{{flight.id}}</td>
						<!--<td>From {{flight.route.from}}to {{flight.route.to}}</td>-->
						<!--<td><a href = "./editFlight?id={{flight.id}}" class = "btn btn-default btn-lg" role = "button"><i class="glyphicon glyphicon-pencil" ></i></a></td>-->
						<td><a href = "#" class = "btn btn-default btn-lg" role = "button"  id="delete_link" number="{{flight.id}}"><i class="glyphicon glyphicon-remove"></i></a></td>
						<td><button class="btn btn-success"><i class="glyphicon glyphicon-list-alt"></i></button></td>
					</tr>
				<!--</c:forEach>-->
				</tbody>
				</table>
			</div>
			<script>
				var app=angular.module('flightsApp',[]);
				app.controller('flightsController',function($scope){
					$scope.flights=[
						{id:1,
							number:111,
							planeName:"Plane1",
							startTime:"Start Time 1",
							flightTime:"Flight Time 1"
						}
					];
				});
			</script>
		</div>

	<footer>
			<div class="container">
				<div class="row">
				</div>
	</div>
		</footer>
		</div>
	</body>
</html>