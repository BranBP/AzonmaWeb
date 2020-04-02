package com.azonma.web.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {

	public static final String prettyParameters(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		Map<String, String[]> parametersMap = request.getParameterMap();
		String[] values = null;
		for (String parameterName: parametersMap.keySet()) {
			sb.append(parameterName).append("={");
			values = parametersMap.get(parameterName);
			if (values==null ) {
				sb.append("null");
			} else {
				for (int i = 0; i<values.length-1; i++) {
					sb.append(values[i]).append(",");
				}
				sb.append(values.length-1);			
			}
			sb.append("} ");
		}
		return sb.toString();
	}
}
