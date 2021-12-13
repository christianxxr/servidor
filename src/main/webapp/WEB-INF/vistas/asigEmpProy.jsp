<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h2>JEFE DE PROYECTO</h2>
		<h3>Asignar a ${usuario.nombre} al proyecto:
			${listaProyectos.idProyecto}</h3>
	</header>
	<section>
		<form action="/jefe/asignarEmpleado" method="post">
			<input type="hidden" name="proyecto.idProyecto"
				value="${listaProyectos.idProyecto}"> <label
				for="fechaIncorporacion">Fecha de incorporación:</label><input
				type="date" name="fechaIncorporacion" required="required"> <label
				for="horasAsignadas">Horas asignadas:</label><input type="number"
				name="horasAsignadas" min="0" step="1" required="required">
			<input type="submit" value="Enviar">
		</form>

	</section>
</body>
</html>