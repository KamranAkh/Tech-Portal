<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
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
		<h2>Add Phone</h2>
		<form action="addphone" method="post">
			<div class="form-group">
				<label>Barcode</label> <input type="text"
					class="form-control" placeholder="Enter barcode"
					name="barcode">
			</div>
			<div class="form-group">
				<label>Brand</label> <input type="text"
					class="form-control" placeholder="Enter brand"
					name="brand">
			</div>
			<div class="form-group">
				<label>Model</label> <input type="text"
					class="form-control" placeholder="Enter model"
					name="model">
			</div>
			<div class="form-group">
				<label>Price</label> <input type="text"
					class="form-control" placeholder="Enter price"
					name="price">
			</div>
			<div class="form-group">
				<label>Quantity</label> <input type="text"
					class="form-control" placeholder="Enter quantity"
					name="quantity">
			</div>
			<button type="submit" class="btn btn-primary">ADD PHONE</button>
		</form>
	</div>
	
</body>
</html>