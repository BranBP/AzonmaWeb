<!DOCTYPE html>
<html lang="es">
	<head> 
		<meta charset="utf-8">
		<title>Azonma</title>
		<link rel="stylesheet" href="/Azonma/css/azonma.css" media="screen"/>
        <meta name="screen" content="width=device-width, initial-scale=1.0">
	</head>
	 
	<body> 
        <div id="contenedor">
            <div id="cabecera">
                <div>
                    <input type="date" name="calendario">
                    <a href="home.html"><img src="../img/azonma/home.png" alt="Home" title="Home"/></a>
                    <a href="https://www.google.com/maps" target="blank"><img src="../img/azonma/ubicacion.png" alt="UbicaciÃ³n" title="UbicaciÃ³n"></a>
                    <a href="http://www.amazon.es" target="blank"><img src="../img/azonma/azonma.png" alt="logoAzonma" title="Azonma"/></a>
					<select name="Idiomas">     
                        <option value="idioma" selected>Idioma</option>
                        <option value="espanol">Español</option>
                        <option value="ingles">English</option>
                        <option value="frances">Français</option>
                    </select>
                    <a href="carrito.html"><img src="../img/azonma/carrito.png" alt="Carrito" title="Carrito"/></a>
                    <!-- AquÃ­ irÃ­a la cuenta, login,...etc -->
                    <p>Hola Usuari@.<br/>Bienvenido!</p>
                </div>
                <form action="home.html" method="get" enctype="multipart/form-data">
                    <div>
                        <input type="search" name="buscador" placeholder="Buscar...">
                        <button>Buscar</button>
                        <select name="Filtros">     
                            <option value="nada" selected>Filtrar por...</option>
                            <optgroup label="Precio">
                                <option value="p1">0€ - 1€</option>
                                <option value="p2">1€ - 10€</option>
                                <option value="p3">10€ - 50€</option>
                                <option value="p4">50€ - 100€</option>
                                <option value="p5">Mayor a 100€</option>
                            </optgroup>
                            <optgroup label="ValoraciÃ³n">
                                <option value="v1">1 estrella</option>
                                <option value="v2">2 estrellas</option>
                                <option value="v3">3 estrellas</option>
                                <option value="v4">4 estrellas</option>
                                <option value="v5">5 estrellas</option>
                            </optgroup>
                        </select>
                    </div>
                </form>
                <hr/>
            </div>

            <div id="pago">
                <div id="vistas">
                    <img src="../img/azonma/frontal.jpg" alt="Vista frontal">
                    <img src="../img/azonma/lateral.jpg" alt="Vista lateral">
                    <img src="../img/azonma/superstar.jpg" alt="Foto original">
                </div>

                <div id="grande">
                    <img src="../img/azonma/superstar.jpg" alt="Foto ampliada">
                </div>

                <div id="comprar">
                    <form action="home.html">
                        <table>
                            <th colspan="7">Adidas Super Star</th>
                            <tr>
                                <td>Precio Inicial</td>
                                <td></td>
                                <td>.</td>
                                <td>.</td>
                                <td>.</td>
                                <td></td>
                                <td>56,00€</td>
                            </tr>
                            
                            <tr>
                                <td>Unidades</td>
                                <td></td>
                                <td>.</td>
                                <td>.</td>
                                <td>.</td>
                                <td></td>
                                <td><input type="number" min="1" required="required"></td>
                            </tr>

                            <tr>
                                <td>Precio Total</td>
                                <td></td>
                                <td>.</td>
                                <td>.</td>
                                <td>.</td>
                                <td></td>
                                <td>56,00€</td>
                            </tr>
                        </table>
                        <button>Añadir al carrito</button>
                        <button>Realizar</button>
                    </form>
                </div>
            </div>

            <div id="resto">
                <form action="vistaDetalle.html">
                    <div>
                        <h1>Comentarios</h1>
                        <div>
                            <input type="text" placeholder="Escriba aquÃ­...">
                            <button><img onmouseout="this.src='../img/azonma/enviar.png'" onmouseover="this.src='../img/azonma/enviarRelleno.png'" src="../img/azonma/enviar.png" alt="Enviar"/></button>
                        </div>
                        <p>
                            <span class="rojo">Jorge:</span> Son unos zapatos muy buenos, los recomiendo
                            <br/>
                            <span class="rojo">AndrÃ©:</span> Son unos zapatos horribles, no los recomiendo
                            <br/>
                            <span class="rojo">ElÃ­as:</span> Son unos zapatos decentes
                            <br/>
                            ...
                        </p>
                    </div>

                    <div>
                        <h2>Valorar</h2>
                        <div>
                            <img onmouseout="this.src='../img/azonma/estrellaVacia.png'" onmouseover="this.src='../img/azonma/estrellaRellenada.png'" src="../img/azonma/estrellaVacia.png">
                            <img onmouseout="this.src='../img/azonma/estrellaVacia.png'" onmouseover="this.src='../img/azonma/estrellaRellenada.png'" src="../img/azonma/estrellaVacia.png">
                            <img onmouseout="this.src='../img/azonma/estrellaVacia.png'" onmouseover="this.src='../img/azonma/estrellaRellenada.png'" src="../img/azonma/estrellaVacia.png">
                            <img onmouseout="this.src='../img/azonma/estrellaVacia.png'" onmouseover="this.src='../img/azonma/estrellaRellenada.png'" src="../img/azonma/estrellaVacia.png">
                            <img onmouseout="this.src='../img/azonma/estrellaVacia.png'" onmouseover="this.src='../img/azonma/estrellaRellenada.png'" src="../img/azonma/estrellaVacia.png">
                            <button><img onmouseout="this.src='../img/azonma/enviar.png'" onmouseover="this.src='../img/azonma/enviarRelleno.png'" src="../img/azonma/enviar.png" alt="Enviar"/></button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
	</body>
</html>