package com.azonma.web.controller;

import java.io.IOException;
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

import com.azonma.exceptions.MailException;
import com.azonma.model.Usuario;
import com.azonma.service.UsuarioService;
import com.azonma.service.impl.UsuarioServiceImpl;
import com.azonma.util.PasswordEncryption;
import com.azonma.web.util.ActionNames;
import com.azonma.web.util.AttributeNames;
import com.azonma.web.util.Errors;
import com.azonma.web.util.ParameterNames;
import com.azonma.web.util.SessionManager;
import com.azonma.web.util.ViewPaths;
import com.azonma.web.util.WebUtils;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L; 

	private static Logger logger = LogManager.getLogger(UsuarioServlet.class);

	private UsuarioService us = null;


	public UsuarioServlet() {
		super();
		us = new UsuarioServiceImpl();

	}
	// errores x corregir x nulos al no insertar campos ...
	// else sino es nulo n vale validaciones etc .. x hacer en ambos singin y singup

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		if (logger.isDebugEnabled()) {
			logger.debug(WebUtils.prettyParameters(request));
		}

		// falta meter trims para que no haya espacios y que no me mete en fecha un string etc

		String target = null;
		boolean redirect = false;
		String action =request.getParameter(ParameterNames.ACCION);
		// FLAG PARA LOCALIZAR EL ERROR Y NO VOLVERME LOCO

		//  sj la accion es signup  haces todo lo que hay despues del if capturando sus exceptiones y vienddo si es nulo o blanco y convesiones de tipo
		//despues redirige si ah ido bien sino metes un error asociado al parametro que ah ido mal y lo rediriges a la misma jsp con el error para
		// arreglar .. sin posibilidad de avanze
		if (ActionNames.SIGN_UP.equalsIgnoreCase(action)) {
			boolean hasErrors = false;


			// parameters.name  es una clase utilidad de lo que el " user " pone en la jsp "
			String nome = request.getParameter(ParameterNames.NOMBRE_USUARIO);
			String apellidos = request.getParameter(ParameterNames.APELLIDO_USUARIO);
			String direccion = request.getParameter(ParameterNames.DIR);
			String localidad = request.getParameter(ParameterNames.LOCALIDAD);
			String fecha = request.getParameter(ParameterNames.NACIMIENTO);
			String plain_password = request.getParameter(ParameterNames.PASSWORD);
			String telefono = request.getParameter(ParameterNames.TELEFONO);
			String email = request.getParameter(ParameterNames.EMAIL);
			String sexo = request.getParameter(ParameterNames.SEXO);


			//      
			// para futuras conversiones de tipo

			Long idLocalidad = null;

			Date fechaNacemento = null; //porque date en mayuscula y minuscula diferencia

			try{
				// atributos de error en cada parametro dado por el cliente y mostraselo para su posterior correccion
				if (StringUtils.isBlank(nome)  ||  StringUtils.isNumeric(nome)) {
					hasErrors = true;
					request.setAttribute(AttributeNames.ERROR_NOMBRE_USUARIO, Errors.REQUIRED_FIELD_ERROR);
					logger.debug("el dato es un num o vacio " +nome);
				}
				else {
					nome = nome.trim();  // esto no vale ...

				}

				if (StringUtils.isBlank(apellidos) ||  StringUtils.isNumeric(apellidos)) {
					hasErrors = true;
					request.setAttribute(AttributeNames.ERROR_APELLIDO_USUARIO, Errors.REQUIRED_FIELD_ERROR);


				}else {
					apellidos = apellidos.trim();

				}


				if (StringUtils.isBlank(direccion)) {
					hasErrors = true;
					request.setAttribute(AttributeNames.ERROR_DIR, Errors.REQUIRED_FIELD_ERROR);

				}else {
					direccion = direccion.trim();

				}

				if (!StringUtils.isBlank(localidad)) {
					localidad = localidad.trim();
					idLocalidad = Long.parseLong(request.getParameter(AttributeNames.LOCALIDAD)) ;
					// // String idiomas = request.getParameterValue(ParameterNames.ID_DIOMA);// meter nombre en query haciendo joins

				}else {  
					hasErrors = true;
					request.setAttribute(AttributeNames.ERROR_LOC, Errors.REQUIRED_FIELD_ERROR);

				}
				if (!StringUtils.isBlank(fecha)) {
					// le meto trim pese a no saber si aqui sirve o no
					// fecha = fecha.trim();
					fechaNacemento = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);

				}else {
					hasErrors = true;
					request.setAttribute(AttributeNames.ERROR_DATE, Errors.REQUIRED_FIELD_ERROR);
				}

				if (StringUtils.isBlank(plain_password)) {
					request.setAttribute(AttributeNames.ERROR_PASSWORD, Errors.REQUIRED_FIELD_ERROR);
					hasErrors = true;
				}else {
					plain_password = plain_password.trim();



				}if (StringUtils.isBlank(telefono)) {
					hasErrors = true;
					request.setAttribute(AttributeNames.ERROR_PHONE_NUMBER, Errors.REQUIRED_FIELD_ERROR);
				}else {
					telefono = telefono.trim();



				}if (StringUtils.isBlank(email)) {
					hasErrors = true;
					request.setAttribute(AttributeNames.ERROR_EMAIL, Errors.REQUIRED_FIELD_ERROR);
				}else {
					email = email.trim();


				}if (StringUtils.isBlank(sexo )) {
					hasErrors = true;
					request.setAttribute(AttributeNames.ERROR_GENDER, Errors.REQUIRED_FIELD_ERROR);

				}else {
					sexo = sexo.trim();

				}


				if (hasErrors) {
					// target = ViewsPaths.SIGN_UP;

					target = ViewPaths.SIGN_UP;

					// recuperar los atributos


					// si no hay ningun error que es rrarro pues crea
					//el usuario con los parametros dados por el usuario en la jsp

					// validar que solo sea un correo  lo que me envia
					// charAt(0) meter que solo sean hasta 3 char como
					// en db para que no pete si me lo mete x f12 o fisgando
				}else {
					Usuario u = new Usuario();
					u.setNombre(nome);
					u.setApellidos(apellidos);
					u.setDireccion(direccion);
					u.setLocalidad(idLocalidad);
					u.setFechaNacimiento(fechaNacemento);
					u.setPassword(PasswordEncryption.encryptPassword(plain_password));
					u.setTelefono(telefono);
					u.setEmail(email);
					u.setSexo(sexo);

					if (logger.isDebugEnabled()) {
						logger.debug("Usuario: " +u) ;
					}

					us.create(u); // llamo al service  donde meto al nuevo usuario

					logger.info("usuario creado con exito"+u);

					target = request.getContextPath()+ViewPaths.SIGN_IN;
					redirect = true;
					// ya creado y si todo salio bien ire al signin para entrar como usuario y irse de fiesta

					// errores en el targer fijo ... o en viewpats
				}

			}catch (MailException e) {
				logger.error(e.getMessage(),e);
				request.setAttribute(AttributeNames.ERROR, Errors.MAIL_ERROR);
				// si se lanza una expcecion la capturo la saco y le meto el atributo que es distinto al de arriba ua que antes era requerrido
				target = ViewPaths.SIGN_UP;
				// request.getRequestDispatcher(ViewPaths.SIGN_UP).forward(request, response);
				// reediriges a misma pag con los atributos y erroes hasta que lo haga bien o se canse
			}catch (NumberFormatException nfe) {
				nfe.printStackTrace();
				logger.error("pinta nulo la fecha", nfe) ;
			}catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage(),e);
				request.setAttribute(AttributeNames.ERROR, Errors.GENERIC_ERROR);
				target = ViewPaths.SIGN_UP;
				// capturar exceptions para que no pete y meter en la mail excepcion que es de commons en la tuya envolviendola

			}
		}else if (ParameterNames.SIGNIN.equalsIgnoreCase(action)) {
			// mirar si usuario es nulo ..  errores no redirige


			String email = request.getParameter(ParameterNames.EMAIL);
			String password = request.getParameter(ParameterNames.PASSWORD);
			Usuario u = new Usuario ();
			request.setAttribute(AttributeNames.EMAIL, email);



			if (!StringUtils.isEmpty(email)) {

				request.setAttribute(AttributeNames.ERROR_EMAIL, Errors.REQUIRED_FIELD_ERROR);
			}
			if (StringUtils.isEmpty(password)) {

				request.setAttribute(AttributeNames.ERROR_PASSWORD, Errors.REQUIRED_FIELD_ERROR);
			}

			else {
				// si hay email y pw es decir hau usuario creado

				try {
					// si no hay  nulos o vacios busca si el  email con el que te registraste y si la pw encriptad al
					// registrate concuerda con la que le metes  en la clase utilidad esta impenetado gracias a apche communs
					u = us.findByEmail(email); // nose yo si es mejor id
					if (!PasswordEncryptionUtil.checkPassword(password,u.getPassword())) {
						request.setAttribute(AttributeNames.ERROR, Errors.INCORRECT_PASSWORD_ERROR);
					} else {
						SessionManager.set(request, AttributeNames.USUARIO, u); // si no hay u y es null
						//saldria de sesion hacer los filtros y
						//mete dnd puedo ir si esta autentificado
						if (request.getParameter(ParameterNames.RECORDAR_USUARIO)!=null) {
							// CookieManager.addCookie(response, AttributeNames.USER_COOKIE, u.getEmail(), "/", 30*24*60*60); no se ah dado aun
							target = ViewPaths.INDEX; // aun no creada mandaria a enventos  o lo que sea
							redirect = true;
						}


					}
				}catch (Exception e) {
					logger.error(e.getMessage(),e);
					request.setAttribute(AttributeNames.ERROR, Errors.GENERIC_ERROR);
					request.getRequestDispatcher(ViewPaths.SIGN_IN).forward(request, response);
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
