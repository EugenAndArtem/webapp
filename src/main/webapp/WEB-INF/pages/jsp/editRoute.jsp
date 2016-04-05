<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="widht=device-width, initial-scale=1.0">
		<title>Main Page</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="./www/css/style.css" rel="stylesheet">
		
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
			<a href="/src/main/webapp"><img src="./www/images/logo.png" alt="Netcracker Airlines"></a>
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
					<div class="form-group">
						<label for="from">From</label>
						<input type="from" class="form-control" id="from" placeholder="From">
					</div>
					<div class="form-group">
						<label for="to">To</label>
						<input type="to" class="form-control" id="to" placeholder="To">
					</div>
						 <button type="register" class="btn btn-success">Register</button>
					</form>
			</div>
		</div>
		</div>
	</body>
</html>