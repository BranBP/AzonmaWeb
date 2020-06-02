package com.azonma.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.azonma.exceptions.DataException;
import com.azonma.exceptions.MailException;
import com.azonma.model.Usuario;
import com.azonma.service.UsuarioService;
import com.azonma.service.impl.UsuarioServiceImpl;
import com.azonma.web.util.ActionNames;
import com.azonma.web.util.AttributeNames;
import com.azonma.web.util.Errors;
import com.azonma.web.util.ParameterNames;
import com.azonma.web.util.ViewPaths;
import com.azonma.web.util.WebUtils;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

	private static Logger logger = LogManager.getLogger(UsuarioServlet.class);
	
	private static final long serialVersionUID = 1L; 
	private UsuarioService usuarioService = null;

	public UsuarioServlet() {
		super();
		usuarioService = new UsuarioServiceImpl(); 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion = request.getParameter(ParameterNames.ACCION);  
		String target = null;
		boolean redirect = false;

		if (ActionNames.REGISTRO.equalsIgnoreCase(accion)) {

			String email = request.getParameter(ParameterNames.EMAIL);
			String contrasena = request.getParameter(ParameterNames.CONTRASENA);
			String fechaNacimientoPar = request.getParameter(ParameterNames.FECHA_NACIMIENTO);
			String nombreUsuario = request.getParameter(ParameterNames.USUARIO);
			String apellido1 = request.getParameter(ParameterNames.APELLIDO1);
			String apellido2 = request.getParameter(ParameterNames.APELLIDO2);
			String sexo = request.getParameter(ParameterNames.SEXO);
			String idiomaPar = request.getParameter(ParameterNames.IDIOMA);  

			Usuario u = null; 

			boolean hasErrors = false;

			// quitamos los espacios
			email = email.trim();
			contrasena = contrasena.trim();
			fechaNacimientoPar = fechaNacimientoPar.trim();
			nombreUsuario = nombreUsuario.trim();
			apellido1 = apellido1.trim();
			apellido2 = apellido2.trim();
			sexo = sexo.trim();
			idiomaPar = idiomaPar.trim();  

			// convertimos el string al tipo correspondiente
			Date fechaNacimiento = null;
			Integer idioma = null;

			try { 

				if(!StringUtils.isBlank(idiomaPar)) { 
					idioma = Integer.parseInt(idiomaPar);
				}

				if(!StringUtils.isBlank(fechaNacimientoPar)) {
					fechaNacimiento = new SimpleDateFormat("yyyy/MM/dd").parse(fechaNacimientoPar);
				}

			}catch (NumberFormatException | ParseException e) { 
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR, Errors.VALOR_INVALIDO); 
				logger.error("Error. Conversión de los String erróneas");
			}

			if(StringUtils.isBlank(email) || StringUtils.isBlank(contrasena) || StringUtils.isBlank(fechaNacimientoPar)
					|| StringUtils.isBlank(nombreUsuario) || StringUtils.isBlank(apellido1) || StringUtils.isBlank(apellido2)
					|| StringUtils.isBlank(sexo) || StringUtils.isBlank(idiomaPar)) { 
				hasErrors = true;
			}

			// introducimos los datos en el usuario
			u = new Usuario();

			u.setEmail(email);
			u.setContrasena(contrasena);
			u.setFechaNacimiento(fechaNacimiento);
			u.setNombre(nombreUsuario);
			u.setApellido1(apellido1);
			u.setApellido2(apellido2);
			u.setIdSexo(sexo);
			u.setIdIdioma(idioma);

			if(hasErrors) {
				target = ViewPaths.LOGIN;    
				redirect = true;   
			}else {

				// Se continúa con las operaciones en la capa de negocio
				target = ViewPaths.RESULTADOS;   

				try {

					usuarioService.create(u); 

					request.setAttribute(AttributeNames.USUARIO, u);  

				} catch (DataException | MailException e) {
					logger.error(WebUtils.prettyParameters(request));
					request.setAttribute(AttributeNames.ERROR, Errors.ERROR_GENERAL);  
				} 
			}


		}else if (ActionNames.AUTENTICACION.equalsIgnoreCase(accion)) {
			//			TODO

		} else {
			logger.warn("Security issue or bug: Unknown action: "+accion);
			target = request.getContextPath();  
			redirect = true;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Accion = {}, target = {}, redirect = {} ", accion, target, redirect);  
		}

		if(redirect) {
			response.sendRedirect(target);
		}else {
			request.getRequestDispatcher(target).forward(request, response); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
