<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
div {
	display: flex;
	justify-content: center;
}

.tabla1 {
	width: 75%;
	border-collapse: collapse;
	text-align: left;
	margin: 10px;
}

.tabla1 th, td {
	border: solid 1px #AAAAAA;
	text-align: center;
	padding: 10px
}

th {
	background-color: #AAAAAA;
	color: white;
}

td a {
	text-decoration: none;
}

tr {
	color: #B600FF;
}

tr a {
	color: #B600FF;
}

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

	<h2>Listado de Empleados</h2>

	<p>Bienvenid@ ${usuario.nombre}</p>

	<h3>Mensaje: ${mensaje }</h3>

	<a class="salir" href="/RRHH/altaEmpleado">Alta empleado</a>
	<a class="salir" href="/RRHH/cerrarSesionRRHH">Salir</a>

	<div>

		<table class="tabla1">
			<tr>
				<th>Id empleado</th>
				<th>Nombre</th>
				<th>Fecha inicio</th>
				<th>Correo</th>
				<th>Puesto en la empresa</th>
				<th>Contraseña</th>
				<th colspan="3">Opciones</th>
			</tr>

			<c:forEach var="ele" items="${listaEmpleados }">
				<tr>
					<td>${ele.idEmpl }</td>
					<td>${ele.nombre }</td>
					<td><fmt:formatDate pattern="dd-MM-yyyy"
							value="${ele.fechaIngreso }" /></td>
					<td>${ele.correo }</td>
					<td>${ele.perfile.idPerfil }</td>
					<td>${ele.password }</td>
					<td><a href="/RRHH/cambiarPassword/${ele.idEmpl }">Cambiar
							contraseña</a></td>
					<td><a href="/RRHH/cambiarPuesto/${ele.idEmpl }">Cambiar
							puesto</a></td>
					<td><a href="/RRHH/darBaja/${ele.idEmpl }">Dar de
							baja</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>