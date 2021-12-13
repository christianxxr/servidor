<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Iniciar sesion</h2>

	<form action="/login" method="post">

		<p>
			Número de empleado: <input type="number" name="idEmpl">
		</p>
		<p>
			Correo: <input type="email" name="correo">
		</p>
		<p>
			Password: <input type="password" name="password">
		</p>
		<input type="submit" value="Entrar">
		<h3>Mensajes: ${mensaje }</h3>
	</form>

</body>
</html>