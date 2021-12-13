<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Alta cliente</h1>

	<form action="/gestion/altaProducto" method="post">
		<p>
			Id producto: <input type="number" name="idProducto">
		</p>
		<p>
			Descripción breve: <input type="text" name="descripcionBreve">
		</p>
		<p>
			Precio unitario: <input type="number" name="precioUnitario">
		</p>
		<p>
			Stock: <input type="number" name="stock">
		</p>
		<input type="submit" value="Alta producto">

	</form>

</body>
</html>