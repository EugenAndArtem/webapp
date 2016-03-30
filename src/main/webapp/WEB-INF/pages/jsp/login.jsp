<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="widht=device-width, initial-scale=1.0">
		<title>Login Form</title>
		<link href="/resources/css/style.css" rel="stylesheet">
	</head>
	<body>
	<div class="container">
		<div class="row progal">
		</div>
		<div class="row">
			<div class="col-lg-2"></div>
			
				<div class="col-lg-4 greetinginfo">
					<img src="/resources/images/logo.png">
					<h1>Hello, My Friend</h1>
					<p class="text-justify">
					
						Bla bla bla
						
						Bla bla bla
						
						Bla bla blaBla bla bla
						Bla bla blaBla bla blaBla bla bla
						Bla bla bla
						Bla bla bla
						
						Bla bla bla
						
						
						Bla bla bla
						
						
						Konec
					</p>
				</div>
				<div class="col-lg-1"></div>
				<div class="col-lg-3 loginform">
					<%
						String error=(String)request.getSession().getAttribute("error");
						if(error!=null){
					%>
					<%=request.getSession().getAttribute("error")%>
					<%}%>
					<form:form action="loginValidation" method="post" role="form" modelAttribute="userAttribute">
						 <div class="form-group">
							  <form:input type="Login" class="form-control" id="email" placeholder="Login" path="username"/>
						 </div>
						 <div class="form-group">
							  
							 <form:input type="password" class="form-control" id="pass" placeholder="Password" path="password"/>
						 </div>
						 <button type="submit" class="btn btn-success">Enter</button>
						 <hr>
						 <button type="register" class="btn btn-success">Register</button>
					</form:form>
				</div>
				<div class="col-lg-2"></div>
			</div>
		
	</div>
	</body>
</html>