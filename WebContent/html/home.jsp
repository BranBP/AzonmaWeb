<%@page import="com.azonma.web.util.AttributeNames"%>
<%@include file="/html/common/header.jsp"%>
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
			href="/Azonma/producto?<%=ParameterNames.ACCION%>=<%=ActionNames.DETALLE%>&<%=ParameterNames.ID_PRODUCTO%>=<%=p.getIdProducto()%>"><%=p.getNombre()%></a>

	</div>
	<%
		}
		}
	%>
</div>
<%@include file="/html/common/footer.jsp"%>
</html>