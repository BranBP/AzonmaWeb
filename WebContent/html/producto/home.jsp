<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.azonma.web.util.AttributeNames"%>
<%@include file="/html/common/header.jsp"%>
<div id="img">
	<%
		List<Producto> productos = (List<Producto>) request.getAttribute(AttributeNames.PRODUCTOS);

		if (productos != null) {
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
		}
	%>
</div>
<%@include file="/html/common/footer.jsp"%>