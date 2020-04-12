package com.azonma.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.azonma.exceptions.DataException;
import com.azonma.model.Producto;
import com.azonma.model.criteria.ProductoCriteria;
import com.azonma.service.ProductoService;
import com.azonma.service.impl.ProductoServiceImpl;
import com.azonma.web.util.ActionNames;
import com.azonma.web.util.AttributeNames;
import com.azonma.web.util.Errors;
import com.azonma.web.util.ParameterNames;
import com.azonma.web.util.ViewPaths;
import com.azonma.web.util.WebUtils;

@WebServlet("/producto")
public class ProductoServlet extends HttpServlet { 

	private static Logger logger = LogManager.getLogger(ProductoServlet.class);

	private static final long serialVersionUID = 1L;
	private ProductoService productoService = null;

	public ProductoServlet() { 
		super();
		productoService = new ProductoServiceImpl(); 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion = request.getParameter(ParameterNames.ACCION);  
		String target = null;
		boolean redirect = false;	

		if (ActionNames.BUSQUEDA.equalsIgnoreCase(accion)) { 

			String precioDesdePar = request.getParameter(ParameterNames.PRECIO_DESDE);
			String precioHastaPar = request.getParameter(ParameterNames.PRECIO_HASTA); 
			String nombreProducto = request.getParameter(ParameterNames.PRODUCTO);    
			String minValPar = request.getParameter(ParameterNames.VALORACION);   

			ProductoCriteria pc = new ProductoCriteria(); 
			boolean hasErrors = false;

			// quitamos los espacios
			precioDesdePar = precioDesdePar.trim();
			precioHastaPar = precioHastaPar.trim();
			nombreProducto = nombreProducto.trim();
			minValPar = minValPar.trim();

			// convertimos el string al tipo correspondiente
			Double precioDesde = null;
			Double precioHasta = null; 
			Integer minVal = null; 

			try {  

				if(!StringUtils.isBlank(precioDesdePar)) {
					precioDesde = Double.parseDouble(precioDesdePar);
				}

				if(!StringUtils.isBlank(precioHastaPar)) {
					precioHasta = Double.parseDouble(precioHastaPar); 
				}

				if(!StringUtils.isBlank(minValPar)) { 
					minVal = Integer.parseInt(minValPar);
				}

			}catch (NumberFormatException nfe) { 
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR, Errors.VALOR_INVALIDO); 
				logger.error("Error. Conversión de los String erróneas");
			}

			// introducimos los datos en el criteria
			pc.setPrecioDesde(precioDesde);
			pc.setPrecioHasta(precioHasta);
			pc.setMinVal(minVal);

			if(nombreProducto!=null) {
				pc.setNombre(nombreProducto);
			}

			if(hasErrors) {
				target = ViewPaths.RESULTADOS;    
			}else {

				// Se continúa con las operaciones en la capa de negocio
				target = ViewPaths.RESULTADOS;  
				try {

					List<Producto> productos = productoService.findByCriteria(pc, 1, Integer.MAX_VALUE); 

					request.setAttribute(AttributeNames.PRODUCTOS, productos);  

				} catch (DataException e) {
					logger.error(WebUtils.prettyParameters(request));
					request.setAttribute(AttributeNames.ERROR, Errors.ERROR_GENERAL);  
				} 
			}


		} else if (ActionNames.DETALLE.equalsIgnoreCase(accion)) {

			request.getParameter(ParameterNames.ID_PRODUCTO);

			Long idProducto = null; 

			try {

				Producto producto = productoService.findById(idProducto);  
				request.setAttribute(AttributeNames.PRODUCTOS, producto); 
				target = ViewPaths.DETALLE;   


			} catch (DataException e) {
				logger.error(WebUtils.prettyParameters(request));
				request.setAttribute(AttributeNames.ERROR, Errors.ERROR_GENERAL);  
			}

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
