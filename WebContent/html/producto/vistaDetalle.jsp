<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.azonma.web.util.AttributeNames"%>
<%@include file="/html/common/header.jsp"%>
<%
	Producto p = (Producto) request.getAttribute(AttributeNames.PRODUCTOS);
	if (p.getNombre() != null) {
%>
<div id="pago">
	<div id="vistas">
		<div>
			<img
				src="<%=ImagePaths.PRODUCTO%><%=p.getIdProducto()%><%=ImageFormats.PRODUCTO_PEQUENO1%>"
				alt="<%=p.getNombre()%>">
		</div>
		<div>
			<img
				src="<%=ImagePaths.PRODUCTO%><%=p.getIdProducto()%><%=ImageFormats.PRODUCTO_PEQUENO2%>"
				alt="<%=p.getNombre()%>">
		</div>
		<div>
			<img
				src="<%=ImagePaths.PRODUCTO%><%=p.getIdProducto()%><%=ImageFormats.PRODUCTO_PEQUENO3%>"
				alt="<%=p.getNombre()%>">
		</div>
	</div>

	<div id="grande">
		<img
			src="<%=ImagePaths.PRODUCTO%><%=p.getIdProducto()%><%=ImageFormats.PRODUCTO_GRANDE%>"
			alt="<%=p.getNombre()%>">
	</div>

	<div id="comprar">
		<div>
			<h1><%=p.getNombre()%></h1>
			<p>
				<i><%=p.getDescripcion()%>.</i>
			</p>
		</div>
		<div>
			<p>
				Precio por unidad
				<%=p.getPrecio()%>€
			</p>
			<p>
				<i> <small> <%
 	if (p.getValoracion() != 0d) {
 %> Valoración media: <%=p.getValoracion()%> <%
 	} else {
 %> Sin valoración <%
 	}
 %>
				</small>
				</i>
			</p>
		</div>
		<div>
			<form action="">
				<p>
					<img src="<%=ImagePaths.ESTRELLA_VACIA%>"> <img
						src="<%=ImagePaths.ESTRELLA_VACIA%>"> <img
						src="<%=ImagePaths.ESTRELLA_VACIA%>"> <img
						src="<%=ImagePaths.ESTRELLA_VACIA%>"> <img
						src="<%=ImagePaths.ESTRELLA_VACIA%>">
				</p>
				<p>
					Unidades: <input type="number" name="<%=ParameterNames.UNIDADES%>">
				</p>
				<button>Comprar</button>
				<button>Añadir al carrito</button>
			</form>
		</div>
	</div>
</div>
<%
	} else {
%>

<div id="img">
	<h4>El producto no existe...</h4>
</div>
<%
	}
%>
<%@include file="/html/common/footer.jsp"%>