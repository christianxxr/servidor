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

	<h1>Terminar un proyecto</h1>

	<form action="/gestion/terminarProyecto" method="post">

		<p>
			Id del proyecto a terminar: <select name="idProyecto">
				<c:forEach var="ele" items="${listaProyectos }">
					<option value="${ele.idProyecto }">${ele.idProyecto }</option>
				</c:forEach>
			</select>
		</p>
		<p>
			Coste real: <input type="number" name="costeReal">
		</p>
		<p>
			Fecha de fin real: <input type="date" name="fechaFinReal">
		</p>
		<input type="submit" value="Terminar proyecto">
	</form>

</body>
</html>