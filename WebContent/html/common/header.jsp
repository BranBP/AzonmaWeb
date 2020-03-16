<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <title>Azonma</title>
    <link rel="stylesheet" href="../../css/azonma.css" media="screen"/>
    <meta name="screen" content="width=device-width, initial-scale=1.0">
</head>

<body> 
    <div id="contenedor">
        <div id="cabecera">
            <div>
                <input type="date" name="calendario"/>
                <a href="home.html"><img src="../../img/web/home.png" alt="Home" title="Home"/></a>
                <a href="https://www.google.com/maps" target="blank"><img src="../../img/web/ubicacion.png" alt="Ubicación" title="Ubicación"></a>
                <a href="http://www.amazon.es" target="blank"><img src="../../img/web/azonma.png" alt="logoAzonma" title="Azonma"/></a>
                <select name="Idiomas">     
                    <option value="idioma" selected>Idioma</option>
                    <option value="espanol">Español</option>
                    <option value="ingles">English</option>
                    <option value="frances">Français</option>
                </select>
                <a href="carrito.html"><img src="../../img/web/carrito.png" alt="Carrito" title="Carrito"/></a>
                <!-- Aquí iría la cuenta, login,...etc -->
                <p>Hola Usuari@.<br/>Bienvenido!</p>
            </div>
            <div>
                <form action="home.html" method="post">
                    <input type="search" name="buscador" placeholder="Buscar...">
                    <select name="precio">     
                        <option value="null" selected>...</option>
                        <option value="p1">0€ - 1€</option>
                        <option value="p2">1€ - 10€</option>
                        <option value="p3">10€ - 50€</option>
                        <option value="p4">50€ - 100€</option>
                        <option value="p5">Mayor a 100€</option>
                    </select>
                    <select name="precio">
                        <option value="null" selected>...</option>
                        <option value="v1">1 estrella</option>
                        <option value="v2">2 estrellas</option>
                        <option value="v3">3 estrellas</option>
                        <option value="v4">4 estrellas</option>
                        <option value="v5">5 estrellas</option>
                    </select>
                </form>
                <button id="buscar">Buscar</button>
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
            <hr/>
        </div>