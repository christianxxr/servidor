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
}

div {
	display: flex;
	justify-content: center;
}

table {
	width: 75%;
	border-collapse: collapse;
	text-align: left;
	margin: 10px;
}

table th, td {
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

	<h2>Detalle del Proyecto Seleccionado</h2>
	<div>
		<table>
			<tr>
				<th>Id del proyecto</th>
				<th>Coste Real</th>
				<th>Costes previstos</th>
				<th>Descripción</th>
				<th>Estado</th>
				<th>Fecha de fin prevista</th>
				<th>Fecha de fin real</th>
				<th>Fecha de inicio</th>
				<th>Venta prevista</th>
				<th>Cliente asignado</th>
				<th>Jefe de proyecto</th>
			</tr>
			<tr>
				<td>${listaProyectos.idProyecto}</td>
				<td>${listaProyectos.costeReal }</td>
				<td>${listaProyectos.costesPrevisto }</td>
				<td>${listaProyectos.descripcion}</td>
				<td>${listaProyectos.estado }</td>
				<td><fmt:formatDate pattern="dd-MM-yyyy"
						value="${listaProyectos.fechaFinPrevisto }" /></td>
				<td><fmt:formatDate pattern="dd-MM-yyyy"
						value="${listaProyectos.fechaFinReal }" /></td>
				<td><fmt:formatDate pattern="dd-MM-yyyy"
						value="${listaProyectos.fechaInicio }" /></td>
				<td>${listaProyectos.ventaPrevisto }</td>
				<td>${listaProyectos.cliente.nombre }</td>
				<td>${listaProyectos.jefeProyecto.nombre }</td>
			</tr>
			<tr>
				<th colspan="6">Empleados asignados</th>
			</tr>
			<c:forEach var="ele" items="${listaProyectos.proyectoConEmpleados}">
				<tr>
					<td colspan="2">${ele.numeroOrden }</td>
					<td colspan="2">${ele.empleado.nombre }</td>
					<td colspan="2">${ele.empleado.correo }</td>
				</tr>
			</c:forEach>
			<tr>
				<th colspan="6">Productos asignados</th>
			</tr>
			<c:forEach var="ele" items="${listaProyectos.proyectoConProductos}">
				<tr>
					<td colspan="2">${ele.numeroOrden }</td>
					<td colspan="2">${ele.producto.descripcionBreve }</td>
					<td colspan="2">${ele.producto.stock}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<a href="/jefe/proyectos">Volver a inicio</a>

</body>
</html>