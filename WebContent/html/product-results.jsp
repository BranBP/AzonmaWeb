<%@ page import="java.util.List, com.azonma.model.Producto, com.azonma.web.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Azonma</title>
</head>
<body>

	<%
		List<Producto> productos = (List<Producto>) request.getAttribute(AttributeNames.PRODUCTOS);
	
		if (productos != null) {
			for (Producto p : productos) {
	%>
	<li><%=p.getNombre()%></li>
	<%
		}
		}
	%>

</body>
</html>