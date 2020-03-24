<%@ page import="com.azonma.web.util.*, java.util.*, com.azonma.model.*"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Azonma</title>
<link rel="stylesheet" href="/Azonma/css/azonma.css" />
</head>

<body>
	<div id="contenedor">
		<div id="cabecera">
			<div>
				<input type="date" name="calendario"> <a href="home.html"><img
					src="/Azonma/img/azonma/home.png" alt="Home" title="Home" /></a> <a
					href="https://www.google.com/maps" target="blank"><img
					src="/Azonma/img/web/ubicacion.png" alt="Ubicación"
					title="Ubicación"></a> <a href="http://www.amazon.es"
					target="blank"><img src="/Azonma/img/azonma/azonma.png"
					alt="logoAzonma" title="Azonma" /></a> <select name="Idiomas">
					<option value="idioma" selected>Idioma</option>
					<option value="espanol">Español</option>
					<option value="ingles">English</option>
					<option value="frances">Français</option>
				</select> <a href="carrito.html"><img
					src="/Azonma/img/azonma/carrito.png" alt="Carrito" title="Carrito" /></a>
				<!-- Aquí iría la cuenta, login,...etc -->
				<p>
					Hola Usuari@.<br />Bienvenido!
				</p>
			</div>
			<form action="<%=ControllerPaths.PRODUCTO%>" method="post">
				<input type="hidden" name="<%=ParameterNames.ACTION%>"
					value="<%=ActionNames.SEARCH%>" />
				<div>
					<input type="search" name="<%=ParameterNames.NOMBRE%>"
						placeholder="Buscar..."> <select name="Filtros">
						<option value="nada" selected>Filtrar por...</option>
						<optgroup label="Precio">
							<option value="p1">0€ - 1€</option>
							<option value="p2">1€ - 10€</option>
							<option value="p3">10€ - 50€</option>
							<option value="p4">50€ - 100€</option>
							<option value="p5">Mayor a 100€</option>
						</optgroup>
						<optgroup label="Valoración">
							<option value="v1">1 estrella</option>
							<option value="v2">2 estrellas</option>
							<option value="v3">3 estrellas</option>
							<option value="v4">4 estrellas</option>
							<option value="v5">5 estrellas</option>
						</optgroup>
					</select>
					<button>Buscar</button>
				</div>
			</form>
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

		<div id="img">
			<%
				List<Producto> productos = (List<Producto>) request.getAttribute(AttributeNames.PRODUCTOS);

				if (productos != null) {

					for (Producto p : productos) {
			%>
			<div>
				<a
					href="/Azonma/producto?<%=ParameterNames.ID_PRODUCTO%>=<%=p.getIdProducto()%>">
					<img src="/Azonma/img/azonma/superstar.jpg" alt="Adidas Super Star" />
				</a>
				<p><%=p.getValoracion()%><img
						src="/Azonma/img/azonma/estrella.png" alt="Valoración" /><%=p.getPrecio()%>€
				</p>
				<a
					href="/Azonma/producto?<%=ParameterNames.ACTION%>=<%=ActionNames.DETAIL%>&<%=ParameterNames.ID_PRODUCTO%>=<%=p.getIdProducto()%>"><%=p.getNombre()%></a>
			</div>
			<%
				} // for
				} // if
			%>
		</div>
	</div>
</html>