<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<meta charset="ISO-8859-1">
	<title>Tech Portal</title>
	
	<link rel="icon" href="resources/images/icon.png"/>
	<link rel="stylesheet" href="resources/css/Style.css" type="text/css" />
</head>
<body>

	<%@ include file="Navbar.jsp"%>
	<div class="container">
		<h2>Login</h2>
		<form action="userlog" method="post">
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" placeholder="Enter email"
					name="email">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" placeholder="Enter password"
					name="password">
			</div>
			<button type="submit" class="btn btn-primary">User LOGIN</button>
			<button type="submit" class="btn btn-primary" onclick="form.action='adminlog';">Admin LOGIN</button>
		</form>
	</div>


</body>
</html>