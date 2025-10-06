<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Productos</title>
	<c:set var="context" value="${pageContext.request.contextPath}"/>
	<link rel="stylesheet" type="text/css" href="${context}/css/alumnos.css">
</head>
<body>
	<header class="cabecera">
		<h2>Listado Alumnos</h2>
	</header>

	<div id="contPrincipal">
		<table id="tabla_datos">
			<thead>
				<tr>
					<th>DNI</th>
					<th>Nombre</th>
					<th>Apellido1</th>
					<th>Matricula</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="alumno" items="${alumnos}">
					<tr>
						<td>${alumno.dni}</td>
						<td>${alumno.nombre}</td>
						<td>${alumno.apellido1}</td>
						<td>${alumno.matricula}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/menu"><button>Volver</button></a>
	</div>
</body>
</html>