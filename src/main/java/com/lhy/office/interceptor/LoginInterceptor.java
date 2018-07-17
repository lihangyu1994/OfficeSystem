package com.lhy.office.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登录拦截器
 * @author Administrator
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getSession().getAttribute("user") != null) {
			return true;
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("window.parent.location='" + request.getContextPath() + "'/login.jsp");
			out.print("</script>");
			return false;
		}
	}
}
