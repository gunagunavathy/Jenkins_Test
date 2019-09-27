package com.dhanjyothi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ApplicationFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Init method call");
	}

	public void destroy() {
		System.out.println("Destroy method call");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("Dofilter method call");
		try {
			filterChain.doFilter(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errormessage", e);
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
		}
	}
}
