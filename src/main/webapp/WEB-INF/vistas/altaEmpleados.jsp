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

	<h1>Alta empleado</h1>

	<form action="/RRHH/altaEmpleado" method="post">
		<p>
			Id empleado: <input type="number" name="idEmpl">
		</p>
		<p>
			Nombre: <input type="text" name="nombre">
		</p>
		<p>
			Correo: <input type="email" name="correo">
		</p>
		<p>
			Puesto: <select name="perfile.idPerfil">
				<c:forEach var="ele" items="${listaPerfiles }">
					<option value="${ele.idPerfil }">${ele.nombre }</option>
				</c:forEach>
			</select>
		</p>
		<p>
			Fecha de ingreso: <input type="date" name="fechaIngreso">
		</p>
		<p>
			Fecha de nacimiento: <input type="date" name="fechaNacimiento">
		</p>
		<p>
			Contraseña: <input type="password" name="password">
		</p>
		<input type="submit" value="Alta empleado">
	</form>

</body>
</html>