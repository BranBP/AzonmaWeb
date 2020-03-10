package com.azonma.web.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.azonma.service.ProvinciaService;
import com.azonma.service.impl.ProvinciaServiceImpl;
import com.google.gson.Gson;

@WebServlet("/provinciaws")
public class ProviciaServlet extends HttpServlet {

	private static Logger logger = LogManager.getLogger(ProviciaServlet.class.getName());

	private ProvinciaService provinciaService = null;

	public ProviciaServlet() {
		super(); 
		provinciaService = new ProvinciaServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			Object result = null;
			String method = request.getParameter("m");
			if ("nombre".equalsIgnoreCase(method)) {
				String nombre = request.getParameter("nombre");

				logger.debug("Buscando provincias con {}", nombre);				
				result = provinciaService.findByNombre(nombre);				
				
			} else if ("pais".equalsIgnoreCase(method)) {	
				
				String pais = request.getParameter("pais");								
				// validaciones
				// ...
				Long idPais = Long.valueOf(pais);				
				logger.debug("Buscando provincias pais {}",  pais);				
				result = provinciaService.findByPais(idPais);
			} else {
				logger.warn("Unknown requested method: {}", method);
			}
			
			Gson gson = new Gson();				
			String json = gson.toJson(result);				
			logger.debug(json);

			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(json);
			out.flush();	
			
		}catch (Exception e) {
			logger.error(request.getParameterMap()); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
