package com.azonma.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azonma.exceptions.DataException;
import com.azonma.model.Producto;
import com.azonma.model.criteria.ProductoCriteria;
import com.azonma.service.ProductoService;
import com.azonma.service.impl.ProductoServiceImpl;
import com.azonma.web.util.ActionNames;
import com.azonma.web.util.AttributeNames;
import com.azonma.web.util.ParameterNames;
import com.azonma.web.util.ViewPaths;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/producto")
public class ProductoServlet extends HttpServlet { 

	private static final long serialVersionUID = 1L;
	private ProductoService productoService = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductoServlet() { 
		super();
		productoService = new ProductoServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter(ParameterNames.ACTION);  

		if (ActionNames.SEARCH.equalsIgnoreCase(action)) {

			String nombreProducto = request.getParameter(ParameterNames.NOMBRE); 
			ProductoCriteria pc = new ProductoCriteria();
			pc.setNombre(nombreProducto);

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
