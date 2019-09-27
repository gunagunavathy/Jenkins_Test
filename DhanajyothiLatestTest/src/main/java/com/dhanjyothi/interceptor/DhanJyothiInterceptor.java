package com.dhanjyothi.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dhanjyothi.model.User;

public class DhanJyothiInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		/*RequestMapping rm = ((HandlerMethod) handler).getMethodAnnotation(
                RequestMapping.class);
		boolean loginRequested = false;
		boolean alreadyLoggedIn = false;
        if(rm != null && rm.value().length > 0) {
        	if("login".equals(rm.value()[0])){
        		loginRequested = true;
        	}
        }
		HttpSession ses = request.getSession();
		Customer cust = (Customer)ses.getAttribute("cust");
		if(cust != null) {
			alreadyLoggedIn = true;
		} 
		
		if (alreadyLoggedIn && loginRequested) {
            response.sendRedirect(request.getContextPath() + "/accsummary");
            return false;
        } else if (!alreadyLoggedIn && !loginRequested) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }*/

			return true;
	}


}
