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
				<i> <small>
						<%
							if (p.getValoracion() != 0d) {
						%> Valoración media: <%=p.getValoracion()%>
						<%
							} else {
						%> Sin valoración <%
							}
						%>
				</small></i>
			</p>
			<p>
				<img alt="" src="<%=ImagePaths.ESTRELLA_VACIA%>"> <img alt=""
					src="<%=ImagePaths.ESTRELLA_VACIA%>"> <img alt=""
					src="<%=ImagePaths.ESTRELLA_VACIA%>"> <img alt=""
					src="<%=ImagePaths.ESTRELLA_VACIA%>"> <img alt=""
					src="<%=ImagePaths.ESTRELLA_VACIA%>">
			</p>
		</div>
		<div>
			<button>Comprar</button>
			<button>Añadir al carrito</button>
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