<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Cambiar contraseña del empleado ${listaEmpleados.nombre}</h2>

	<form action="/RRHH/cambiarPassword" method="post">
		<p>
			Id empleado: <input type="number" name="idEmpl" readonly="readonly"
				value="${listaEmpleados.idEmpl }">
		</p>
		<p>
			Antigua contraseña: <input type="text" readonly="readonly"
				value="${listaEmpleados.password }">
		</p>
		<p>
			Ingrese la nueva contraseña: <input type="text" name="password"
				required="required">
		</p>
		<input type="submit" value="Cambiar contraseña">
	</form>

</body>
</html>