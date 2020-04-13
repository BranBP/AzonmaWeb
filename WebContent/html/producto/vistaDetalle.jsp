<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.azonma.web.util.AttributeNames"%>
<%@include file="/html/common/header.jsp"%>
<%
	Producto p = (Producto) request.getAttribute(AttributeNames.PRODUCTOS);
%>
<div id="pago">
	<div id="vistas">
		<div>
			<img src="<%=ImagePaths.PRODUCTO%><%=p.getIdProducto()%>/2.jpg"
				alt="<%=p.getNombre()%>">
		</div>
		<div>
			<img src="<%=ImagePaths.PRODUCTO%><%=p.getIdProducto()%>/3.jpg"
				alt="<%=p.getNombre()%>">
		</div>
		<div>
			<img src="<%=ImagePaths.PRODUCTO%><%=p.getIdProducto()%>/4.jpg"
				alt="<%=p.getNombre()%>">
		</div>
	</div>

	<div id="grande">
		<img src="<%=ImagePaths.PRODUCTO%><%=p.getIdProducto()%>/1.jpg"
			alt="<%=p.getNombre()%>">
	</div>

	<div id="comprar">
		<h1><%=p.getNombre()%></h1>
		<p>Precio por unidad . . . <%=p.getPrecio()%>€</p>
		<p><i><%=p.getDescripcion()%>.</i></p>
	</div>
</div>

<div id="resto">
	<form action="vistaDetalle.html">
		<div>
			<h2>Comentarios</h2>
			<div>
				<input type="text" placeholder="Escriba aquÃ­...">
				<button>
					<img onmouseout="this.src='../img/azonma/enviar.png'"
						onmouseover="this.src='../img/azonma/enviarRelleno.png'"
						src="../img/azonma/enviar.png" alt="Enviar" />
				</button>
			</div>
			<p>
				<span class="rojo">Jorge:</span> Son unos zapatos muy buenos, los
				recomiendo <br /> <span class="rojo">AndrÃ©:</span> Son unos
				zapatos horribles, no los recomiendo <br /> <span class="rojo">ElÃ­as:</span>
				Son unos zapatos decentes <br /> ...
			</p>
		</div>

		<div>
			<h3>Valorar</h3>
			<div>
				<img onmouseout="this.src='../img/azonma/estrellaVacia.png'"
					onmouseover="this.src='../img/azonma/estrellaRellenada.png'"
					src="../img/azonma/estrellaVacia.png"> <img
					onmouseout="this.src='../img/azonma/estrellaVacia.png'"
					onmouseover="this.src='../img/azonma/estrellaRellenada.png'"
					src="../img/azonma/estrellaVacia.png"> <img
					onmouseout="this.src='../img/azonma/estrellaVacia.png'"
					onmouseover="this.src='../img/azonma/estrellaRellenada.png'"
					src="../img/azonma/estrellaVacia.png"> <img
					onmouseout="this.src='../img/azonma/estrellaVacia.png'"
					onmouseover="this.src='../img/azonma/estrellaRellenada.png'"
					src="../img/azonma/estrellaVacia.png"> <img
					onmouseout="this.src='../img/azonma/estrellaVacia.png'"
					onmouseover="this.src='../img/azonma/estrellaRellenada.png'"
					src="../img/azonma/estrellaVacia.png">
				<button>
					<img onmouseout="this.src='../img/azonma/enviar.png'"
						onmouseover="this.src='../img/azonma/enviarRelleno.png'"
						src="../img/azonma/enviar.png" alt="Enviar" />
				</button>
			</div>
		</div>
</div>
<%@include file="/html/common/footer.jsp"%>