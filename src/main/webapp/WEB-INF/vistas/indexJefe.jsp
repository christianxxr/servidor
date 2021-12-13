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
.menu {
	display: flex;
}

.menu a {
	border: 2px solid #00AEFF;
	padding: 0.625em;
	color: #000;
	display: block;
	text-decoration: none;
	text-transform: uppercase;
	font-weight: 400;
	width: 100%;
	text-align: center;
	transition: 0.2s ease all;
	font-size: 1em;
}

.menu a:hover {
	background: #00AEFF;
}

h2 {
	color: #B600FF;
}

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

	<h2>Listado de Proyectos Activos</h2>

	<p>Bienvenid@ ${usuario.nombre}</p>

	<h3>Mensaje: ${mensaje }</h3>

	<a class="salir" href="/jefe/cerrarSesionJefe">Salir</a>

	<div>

		<table class="tabla1">
			<tr>
				<th>Id proyecto</th>
				<th>Descripcion</th>
				<th>Fecha inicio</th>
				<th colspan="2">Opciones</th>
			</tr>

			<c:forEach var="ele" items="${listaProyectos }">
				<c:if test="${ele.jefeProyecto.idEmpl == usuario.idEmpl }">
					<tr>
						<td>${ele.idProyecto }</td>
						<td>${ele.descripcion }</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${ele.fechaInicio }" /></td>
						<td><a href="/jefe/verDetalle/${ele.idProyecto }">Detalle</a></td>
						<td><a href="/jefe/asignarEmpleado/${ele.idProyecto }">Asignar
								empleado</a></td>
					</tr>
				</c:if>
			</c:forEach>
		</table>

	</div>
</body>
</html>