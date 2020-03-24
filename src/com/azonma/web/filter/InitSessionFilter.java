package com.gzone.ecommerce.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gzone.ecommerce.web.controller.SessionAttributeNames;
import com.gzone.ecommerce.web.model.ShoppingCart;
import com.gzone.ecommerce.web.util.SessionManager;


public class InitSessionFilter implements Filter {

	private static Logger logger = LogManager.getLogger(InitSessionFilter.class.getName());
  
    public InitSessionFilter() {       
    }

	public void init(FilterConfig cfg) throws ServletException {
		// Habitualmente se configuran en el web.xml´
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = ((HttpServletRequest) request);
		HttpSession session = httpRequest.getSession(false);
		
		if (session==null) {
			if (logger.isInfoEnabled()) {
				logger.info("Request from "+request.getRemoteAddr()+": Initializing session...");
			}
			// Inicializa la sesion
			session = httpRequest.getSession(true);
			
			// Estado comun requerido
			ShoppingCart c = new ShoppingCart();
			SessionManager.set(httpRequest, SessionAttributeNames.SHOPPING_CART, c);
			
		} 

		chain.doFilter(request, response);
	}




}
