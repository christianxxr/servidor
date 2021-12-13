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

	<form action="/gestion/altaCliente" method="post">
		<p>
			Cif: <input type="text" name="cif">
		</p>
		<p>
			Domicilio: <input type="text" name="domicilio">
		</p>
		<p>
			Facturación anual: <input type="number" name="facturacionAnual">
		</p>
		<p>
			Nombre: <input type="text" name="nombre">
		</p>
		<p>
			Numero de empleados: <input type="number" name="numeroEmpleados">
		</p>

		<input type="submit" value="Alta cliente">

	</form>

</body>
</html>