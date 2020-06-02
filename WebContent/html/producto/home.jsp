<%@page import="com.azonma.service.impl.ProductoServiceImpl"%>
<%@page import="com.azonma.service.ProductoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.azonma.web.util.AttributeNames"%>
<%@include file="/html/common/header.jsp"%>
<div id="img">
	<%
		List<Producto> productos = (List<Producto>) request.getAttribute(AttributeNames.PRODUCTOS);

		if (productos == null) {

			productos = new ArrayList<Producto>();
			Producto p = new Producto();

			ProductoServiceImpl productoService = new ProductoServiceImpl();

			int i = 1;

			while (i <= 6) {

				p = productoService.findById(Math.round(Math.random() * 32));

				if (!productos.contains(p.getIdProducto())) {
					productos.add(p);
					i++;
				}
			}
		}

		if (productos.size() != 0) {
			for (Producto p : productos) {
	%>
	<div>
		<a
			href="<%=ControllerPaths.PRODUCTO%>?<%=ParameterNames.ACCION%>=<%=ActionNames.DETALLE%>&<%=ParameterNames.ID_PRODUCTO%>=<%=p.getIdProducto()%>">
			<img
			src="<%=ImagePaths.PRODUCTO%><%=p.getIdProducto()%><%=ImageFormats.PRODUCTO_GRANDE%>"
			alt="<%=p.getNombre()%>" />
		</a>
		<p>
			<%
				if (p.getValoracion() != 0d) {
			%><%=p.getValoracion()%><img src="<%=ImagePaths.ESTRELLA%>"
				alt="Valoración" />
			<%
				} else {
			%><i>Sin valoración</i>&nbsp;
			<%
				}
			%><%=p.getPrecio()%>€
		</p>
		<a
			href="<%=ControllerPaths.PRODUCTO%>?<%=ParameterNames.ACCION%>=<%=ActionNames.DETALLE%>&<%=ParameterNames.ID_PRODUCTO%>=<%=p.getIdProducto()%>"><%=p.getNombre()%></a>
		<br />
	</div>
	<%
		}
		} else {
	%>
	<h4>Criterios no encontrados...</h4>
	<%
		}
	%>
</div>
<%@include file="/html/common/footer.jsp"%>