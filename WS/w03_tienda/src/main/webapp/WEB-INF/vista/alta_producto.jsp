<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Productos</title>
<link rel="stylesheet" type="text/css" href="${css}/crear_productos.css">
</head>
<body>
	<header class="cabecera">
			<h2>Alta de producto</h2>
	</header>
	
	<div id="contPrincipal">
		<form action="${home}/alta_productos" method="post">
			<input type="text" name="descripcion" placeholder="Descripcion">
			<input type="number" name="precio" placeholder="Precio">
			
			<button type="submit">Crear</button>
		</form>
			
		
		<a href="${home}/menu_principal"><button>Volver</button></a>
	</div>
</body>
</html>