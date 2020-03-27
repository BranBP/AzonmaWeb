package com.azonma.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.azonma.exceptions.DataException;
import com.azonma.model.Producto;
import com.azonma.model.criteria.ProductoCriteria;
import com.azonma.service.ProductoService;
import com.azonma.service.impl.ProductoServiceImpl;
import com.azonma.web.util.ActionNames;
import com.azonma.web.util.AttributeNames;
import com.azonma.web.util.ParameterNames;
import com.azonma.web.util.ViewPaths;

@WebServlet("/producto")
public class ProductoServlet extends HttpServlet { 

	private static final long serialVersionUID = 1L;
	private ProductoService productoService = null;

	public ProductoServlet() { 
		super();
		productoService = new ProductoServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter(ParameterNames.ACTION);  
		String target = null;

		if (ActionNames.SEARCH.equalsIgnoreCase(action)) {

			String precioDesdePar = request.getParameter(ParameterNames.PRECIO_DESDE);
			String precioHastaPar = request.getParameter(ParameterNames.PRECIO_HASTA); 
			String nombre = request.getParameter(ParameterNames.NOMBRE);   
			String valoracionPar = request.getParameter(ParameterNames.VALORACION);  
			
			ProductoCriteria pc = new ProductoCriteria(); 
			boolean hasErrors = false;

			if(StringUtils.isBlank(precioDesdePar)) {
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR_PRECIO, Errors.REQUIRED_FIELD);
			}else {
				// quitamos los espacios
				precioDesdePar = precioDesdePar.trim();
				// convertimos el string al tipo correspondiente
				Double precioDesde = null;
				try { 
					precioDesde = Double.parseDouble(precioDesdePar);
				}catch (NumberFormatException nfe) {
					hasErrors = true;
					request.setAttribute(AttributeNames.ERROR_PRECIO, Errors.INVALID_VALUE);
				}
				pc.setPrecioDesde(precioDesde);
			}

			if(hasErrors) {
				target = ViewPaths.PRODUCTO_SEARCH; 
			}

			try {

				List<Producto> productos = productoService.findByCriteria(pc, 1, Integer.MAX_VALUE);
				request.setAttribute(AttributeNames.PRODUCTOS, productos);

				request.getRequestDispatcher(ViewPaths.PRODUCTO_SEARCH).forward(request, response);

			} catch (DataException e) {
				e.printStackTrace();
			} 

		} else if (ActionNames.DETAIL.equalsIgnoreCase(action)) {

			String idProductoPar = request.getParameter(ParameterNames.ID_PRODUCTO);

			Long idProducto = null; 

			try {

				Producto producto = productoService.findById(idProducto);  
				request.setAttribute(AttributeNames.PRODUCTOS, producto);

				request.getRequestDispatcher(ViewPaths.PRODUCTO_DETAIL).forward(request, response);

			} catch (DataException e) {
				e.printStackTrace();
			}
		} else {
			// Vete
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
