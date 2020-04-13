<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.azonma.web.util.*, java.util.*, com.azonma.model.*"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Azonma</title>
<link rel="stylesheet" href="/Azonma/css/azonma.css" media="screen" />
<meta name="screen" content="width=device-width, initial-scale=1.0">
</head>

<body>
	<div id="contenedor">
		<div id="cabecera">
			<div>
				<a href="<%=ViewPaths.HOME%>"><img src="<%=ImagePaths.HOME%>"
					alt="Home" title="Home" /></a> <a href="https://www.google.com/maps"
					target="blank"><img src="<%=ImagePaths.UBICACION%>"
					alt="Ubicación" title="Ubicación"></a> <a
					href="<%=ViewPaths.HOME%>"><img src="<%=ImagePaths.LOGO%>"
					alt="logoAzonma" title="Azonma" /></a> <select name="Idiomas">
					<option value="idioma" selected>Idioma</option>
					<option value="espanol">Español</option>
					<option value="ingles">English</option>
					<option value="frances">Français</option>
				</select> <a href="carrito.html"><img src="<%=ImagePaths.CARRITO%>"
					alt="Carrito" title="Carrito" /></a>
				<!-- Aquí iría la cuenta, login,...etc -->
				<p>
					Hola Usuari@.<br />Bienvenido!
				</p>
			</div>
			<div>
				<form action="<%=ControllerPaths.PRODUCTO%>" method="post">
					<input type="hidden" name="<%=ParameterNames.ACCION%>"
						value="<%=ActionNames.BUSQUEDA%>"> <input type="search"
						name="<%=ParameterNames.PRODUCTO%>" placeholder="Buscar...">
					<select name="<%=ParameterNames.PRECIO_DESDE%>">
						<option selected value="">Precio desde</option>
						<option value="0">0€</option>
						<option value="1">1€</option>
						<option value="10">10€</option>
						<option value="50">50€</option>
						<option value="100">100€</option>
						<option value="1000">1000€</option>
					</select> <select name="<%=ParameterNames.PRECIO_HASTA%>">
						<option selected value="">Precio hasta</option>
						<option value="1">1€</option>
						<option value="10">10€</option>
						<option value="50">50€</option>
						<option value="100">100€</option>
						<option value="1000">1000€</option>
						<option value="10000">10000€</option>
					</select> <select name="<%=ParameterNames.VALORACION%>">
						<option selected value="">Valoración mínima</option>
						<option value="0">0 estrellas</option>
						<option value="1">1 estrella</option>
						<option value="2">2 estrellas</option>
						<option value="3">3 estrellas</option>
						<option value="4">4 estrellas</option>
					</select>
					<button id="buscar">Buscar</button>
				</form>
			</div>
			<div id="categorias">
				<button>Libros</button>
				<button>Películas</button>
				<button>Videojuegos</button>
				<button>Ropa</button>
				<button>Relojes</button>
				<button>Tecnología</button>
				<button>Joyería</button>
				<button>Juguetes</button>
			</div>
			<hr />
		</div>