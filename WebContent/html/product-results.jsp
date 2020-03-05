<%@ page import="java.util.List, com.azonma.model.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Azonma</title>
</head>
<body>

	<%
		List<Producto> productos = (List<Producto>) request.getAttribute("resultados");
	
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