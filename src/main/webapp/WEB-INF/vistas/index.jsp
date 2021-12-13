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
</style>

<body>
	<h3>Bienvenid@ ${usuario.nombre}</h3>
	<nav class="menu">
		<a href="/gestion/altaProyecto">Alta proyecto</a><a
			href="/gestion/terminarProyecto">Terminar proyecto</a> <a
			href="/gestion/altaCliente">Alta Cliente</a> <a
			href="/gestion/altaProducto">Alta producto</a> <a
			href="/gestion/cerrarSesion">Salir</a>
	</nav>
	<h3>Mensajes: ${mensaje }</h3>

	<div>

		<table class="tabla1">
			<tr>
				<th>Id proyecto</th>
				<th>Descripción</th>
				<th>Fecha de inicio</th>
				<th>Cliente</th>
				<th>Jefe proyecto</th>
				<th>Coste previsto</th>
				<th>Fecha prevista de fin</th>
				<th>Venta prevista</th>
				<th>Estado</th>
				<th>Coste real</th>
				<th>Fecha real de fin</th>
			</tr>

			<c:forEach var="ele" items="${listaProyectos }">
				<tr>
					<td>${ele.idProyecto }</td>
					<td>${ele.descripcion }</td>
					<td><fmt:formatDate pattern="dd-MM-yyyy"
							value="${ele.fechaInicio }" /></td>
					<td>${ele.cliente.nombre }</td>
					<td>${ele.jefeProyecto.nombre }</td>
					<td>${ele.costesPrevisto}</td>
					<td><fmt:formatDate pattern="dd-MM-yyyy"
							value="${ele.fechaFinPrevisto }" /></td>
					<td>${ele.ventaPrevisto }</td>
					<td>${ele.estado }</td>
					<td>${ele.costeReal }</td>
					<td><fmt:formatDate pattern="dd-MM-yyyy"
							value="${ele.fechaFinReal }" /></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<div>
		<table class="tabla1">
			<tr>
				<th>Cif cliente</th>
				<th>Domicilio</th>
				<th>Facturación anual</th>
				<th>Nombre</th>
				<th>Número de empleados</th>
			</tr>

			<c:forEach var="ele" items="${listaClientes }">
				<tr>
					<td>${ele.cif }</td>
					<td>${ele.domicilio }</td>
					<td>${ele.facturacionAnual }</td>
					<td>${ele.nombre }</td>
					<td>${ele.numeroEmpleados}</td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<div>
		<table class="tabla1">
			<tr>
				<th>Id producto</th>
				<th>Descripción breve</th>
				<th>Precio unitario</th>
				<th>Stock</th>
			</tr>

			<c:forEach var="ele" items="${listaProductos }">
				<tr>
					<td>${ele.idProducto }</td>
					<td>${ele.descripcionBreve }</td>
					<td>${ele.precioUnitario }</td>
					<td>${ele.stock }</td>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>