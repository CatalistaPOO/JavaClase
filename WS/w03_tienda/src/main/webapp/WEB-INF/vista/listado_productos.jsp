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
<link rel="stylesheet" type="text/css" href="${css}/productos.css">
</head>
<body>
	<header class="cabecera">
			<h2>Busqueda de productos</h2>
	</header>
	
	<div id="contPrincipal">
		<form action="${home}/listado_productos" method="post">
			<input type="search" name="description">
			<button type="submit">Buscar</button>
		</form>
		
		<table id="tabla_datos">
			<thead>
				<tr>
					<th>Descripcion</th>
					<th>Precio</th>
					<th>Fabricante</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>Ordenador_portatil dkdkdkd</th>
					<th>1.589</th>
					<th>asus</th>
				</tr>
				<tr>
					<th>Ordenador_portatil dkdkdkd</th>
					<th>1.589</th>
					<th>asus</th>
				</tr>
				<tr>
					<th>Ordenador_portatil dkdkdkd</th>
					<th>1.589</th>
					<th>asus</th>
				</tr>
			</tbody>
		</table>
		
		<a href="${home}/menu_principal"><button>Volver</button></a>
	</div>
</body>
</html>