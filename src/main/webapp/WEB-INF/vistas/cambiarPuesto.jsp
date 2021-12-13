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

	<h2>Cambiar el puesto del empleado ${listaEmpleados.nombre}</h2>

	<form action="/RRHH/cambiarPuesto" method="post">
		<p>
			Id empleado: <input type="number" name="idEmpl" readonly="readonly"
				value="${listaEmpleados.idEmpl }">
		</p>
		<p>
			Antigua puesto: <input type="text" readonly="readonly"
				value="${listaEmpleados.perfile.nombre }">
		</p>
		<p>
			Cliente asignado:<select name="perfile.nombre">
				<c:forEach var="ele" items="${listaPerfiles}">
					<option value="${ele.idPerfil}">${ele.nombre}</option>
				</c:forEach>
			</select>
		</p>
		<input type="submit" value="Cambiar puesto">
	</form>

</body>
</html>