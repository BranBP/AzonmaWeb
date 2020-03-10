package com.azonma.web.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.azonma.model.Provincia;
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

		String method = request.getParameter("m");
		if("nombre".equalsIgnoreCase(method)) {
			String nombre = request.getParameter("nombre");
			try {
				
				List<Provincia> results = provinciaService.findByNombre(nombre);
				Gson gson = new Gson();
				String json = gson.toJson(results); 

				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(json); 
				out.flush();

			}catch (Exception e) {
				logger.error(request.getParameterMap()); 
			}
		}else if("pais".equalsIgnoreCase(method)){

		}else{
			logger.warn("Unknown raquest method: {}", method);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
