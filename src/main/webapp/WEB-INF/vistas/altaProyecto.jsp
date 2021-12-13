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

	<h1>Alta Proyecto</h1>

	<form action="/gestion/altaProyecto" method="post">

		<p>
			Número de proyecto:<input type="text" name="idProyecto">
		</p>
		<p>
			Cliente asignado:<select name="cliente.cif">
				<c:forEach var="ele" items="${listaClientes}">
					<option value="${ele.cif}">${ele.nombre}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			Jefe de proyecto: <select name="jefeProyecto.idEmpl">
				<c:forEach var="ele" items="${listaEmpleados}">
					<c:if test="${ele.perfile.idPerfil == 2 }">
						<option value="${ele.idEmpl}">${ele.nombre }</option>
					</c:if>
				</c:forEach>
			</select>
		</p>
		<p>
			Descripcion: <input type="text" name="descripcion">
		<p>
			Costes previstos: <input type="number" name="costesPrevisto">
		<p>
			Fecha de fin inicio: <input type="date" name="fechaInicio">
		</p>
		<p>
			Fecha de fin previsto: <input type="date" name="fechaFinPrevisto">
		</p>
		<p>
			Venta prevista: <input type="number" name="ventaPrevisto">
		</p>
		<input type="submit" value="Dar de alta">
	</form>
</body>
</html>