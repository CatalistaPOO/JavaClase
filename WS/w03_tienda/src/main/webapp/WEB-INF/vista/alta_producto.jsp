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
<link rel="stylesheet" type="text/css" href="${css}/alta_producto.css">

<script type="text/javascript">
//VALIDACION DE DATOS A PARTIR DEL BOTON ENVIAR:


function validaForm(ev){//al pasar ev creamos un objeto del evento submit del botón
	ev.preventDefault();//esto hace que no ejecute el evento
	//CAPTURAMOS LOS ID DEL FORMULARIO(form_prod):
	let descripcion = document.getElementById("descripcion").value.trim();
	let precio = document.getElementById("precio").value.trim();
	let fabricante = document.getElementById("fabricante").value;
	/* 
	//ESTO ES UNA COMPROBACION PARA VER LA CAPTURA DEL EVENTO DEL BOTON Y DAR MENSAJE EN VENTANA EMERGENTE
	//Campo de descripción en Crear producto.
	//Si metemos espacios no cuentan y si no escribimos nada estará vacio, si escribimos estará lleno
	if (descripcion.trim())
		alert("tiene un valor");
	else
		alert("está vacío"); */
		
	//CHEQUEAMOS LOS CAMPOS PARA COMPROBAR QUE SE HAN INTRODUCIDO VALORES VÁLIDOS Y NO ESTÁN VACÍOS
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
	document.getElementById("form_prod").addEventListener("submit", validaForm);
}
</script>

</head>
<body>
	<header class="cabecera">
		<h2>Alta de Productos</h2>
	</header>

	<div id="contPrincipal">
		<form id="form_prod" action="${home}/alta_producto" method="post">
			<input id="descripcion" type="text" name="descripcion" placeholder="Descripcion">
			<input id="precio" type="text" name="precio" placeholder="Precio">
			<select id="fabricante" name="idFabricante">
				<option value = "" hidden="hidden">Seleccione Fabricante</option>
				<c:forEach var="fabricante" items="${fabs}">
				<option value="${fabricante.idFabricante}">${fabricante.fabricante}</option>
				</c:forEach>
			</select>
			<button type="submit">Crear</button>
		</form>
		
		<a href="${home}/menu_principal"><button>Volver</button></a>
		<!-- &nbsp; equivale a un espacio, es la palabra reservada. -->
		<p id="error">&nbsp;</p>
	</div>
</body>
</html>