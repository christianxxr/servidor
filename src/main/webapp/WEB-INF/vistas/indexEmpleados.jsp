<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.salir {
	border: 2px solid #00AEFF;
	padding: 0.625em;
	color: #000;
	display: block;
	text-transform: uppercase;
	font-weight: 400;
	width: 10%;
	text-align: center;
	transition: 0.2s ease all;
	font-size: 1em;
	text-decoration: none;
}

.salir:hover {
	background: #00AEFF;
}
</style>
<body>

	<h1>Empleados</h1>

	<h3>Bievenid@ ${usuario.nombre }</h3>

	<a class="salir" href="/empleados/cerrarSesionEmpleado">Salir</a>

</body>
</html>