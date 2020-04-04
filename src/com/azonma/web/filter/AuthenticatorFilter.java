package com.azonma.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.azonma.model.Usuario;
import com.azonma.web.util.AttributeNames;
import com.azonma.web.util.SessionManager;

/**
 * Filtro de autenticación de áreas protegidas.
 */
@WebFilter("/usuario/")
public class AuthenticatorFilter implements Filter {

	public AuthenticatorFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String url = httpRequest.getRequestURL().toString();
		if(url.contains()) {
			Usuario usuario = SessionManager.get(httpRequest, AttributeNames.USER);

			if(u==null) {

			}else {
				chain.doFilter(request, response);
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
