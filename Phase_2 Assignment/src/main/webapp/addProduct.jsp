<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>
	<h1>Add Product</h1>
	<form action="addProduct" method="post">
		<label for="name">Name:</label> <input type="text" id="name"
			name="name" required><br> <label for="price">Price:</label>
		<input type="number" id="price" name="price" required><br>
		<label for="description">Description:</label>
		<textarea id="description" name="description" required></textarea>
		<br> <input type="submit" value="Add Product">
	</form>
</body>
</html>