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
<link rel="stylesheet" type="text/css" href="${css}/alta_producto.css">

<script type="text/javascript">
//VALIDACION DE DATOS A PARTIR DEL BOTON ENVIAR:


function validaForm(ev){//al pasar ev creamos un objeto del evento submit del botón
	ev.preventDefault();//esto hace que no ejecute el evento

	let descripcion = document.getElementById("descripcion").value.trim();
	let precio = document.getElementById("precio").value.trim();
	let fabricante = document.getElementById("fabricante").value;

	let error = document.getElementById("error");
	if (!descripcion.trim() || !precio.trim() || !fabricante.trim()){
		error.textContent = "Todos los campos son obligatorios";
	}else if(isNaN(precio)){
		error.textContent = "El precio debe ser numérico";
	}else if(precio <=0){
		error.textContent = "El precio debe ser mayor que 0";
	}else{
		error.textContent = "";//Borramos el texto que comunica errores
		ev.currentTarget.submit();//devolvemos el evento una vez que todos los campos están chequeados correctamente
	}
	
}

window.onload = function(){
	document.getElementById("form_login").addEventListener("submit", validaForm);
}
</script>

</head>
<body>
	<header class="cabecera">
		<h2>Login</h2>
	</header>

	<div id="contPrincipal">
		<form id="form_login" action="${home}/alta_producto" method="post">
			<input id="usr" type="text" name="usr" placeholder="Usuario">
			<input id="pwd" type="password" name="pwd" placeholder="Password">
			<button type="submit">Login</button>
		</form>
		
		<a href="${home}/menu_principal"><button>Volver</button></a>
		<!-- &nbsp; equivale a un espacio, es la palabra reservada. -->
		<p id="error">&nbsp;</p>
	</div>
</body>
</html>