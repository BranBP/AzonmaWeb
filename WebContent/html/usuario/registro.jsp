<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.azonma.web.util.AttributeNames"%>
<%@include file="/html/common/header2.jsp"%>
<div>
	<form action="<%=ControllerPaths.USUARIO%>" method="post">
		<input type="hidden" name="<%=ParameterNames.ACCION%>"
			value="<%=ActionNames.REGISTRO%>"> <label
			for="<%=ParameterNames.USUARIO%>">Nombre:</label><input type="text"
			id="<%=ParameterNames.USUARIO%>" name="<%=ParameterNames.USUARIO%>"
			placeholder="Antonio"><input type="email"
			name="<%=ParameterNames.EMAIL%>" placeholder="ejemplo@gmail.com"><input
			type="password" name="<%=ParameterNames.CONTRASENA%>"><input
			type="text" name="<%=ParameterNames.APELLIDO1%>" placeholder="García"><input
			type="text" name="<%=ParameterNames.APELLIDO2%>"
			placeholder="Rodríguez"><input type="text"
			name="<%=ParameterNames.FECHA_NACIMIENTO%>"> <input
			type="radio" value="H" name="<%=ParameterNames.SEXO%>"> <input
			type="radio" name="<%=ParameterNames.SEXO%>" value="M"> <input
			type="radio" name="<%=ParameterNames.SEXO%>" value=" "> <select
			name="<%=ParameterNames.IDIOMA%>">
			<option value="1">Español</option>
			<option value="2">English</option>
			<option value="3">Français</option>
		</select>
		<button id="buscar">Registrarse</button>
	</form>
</div>
<%@include file="/html/common/footer.jsp"%>