<%@page import="java.io.Console"%>
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
			Producto producto;

			ProductoServiceImpl productoService = new ProductoServiceImpl();
			
			long id = 0;

			for (int i=0;i<5;i++){
				id = Math.round(Math.random() * 11) + 1;
				producto = productoService.findById( id );
				if( !productos.contains(id) ) productos.add(producto);
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