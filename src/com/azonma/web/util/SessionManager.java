package com.azonma.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionManager {

	public static Object get(HttpServletRequest request, String attName) {
		return getSession(request).getAttribute(attName);
	}

	public static void set(HttpServletRequest request, String attName, Object attValue) {
		getSession(request).setAttribute(attName, attValue);
	}
	
	protected static HttpSession getSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		return session;
	}	
}
