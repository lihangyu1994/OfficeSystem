package com.lhy.office.filter;

import javax.servlet.http.HttpSession;

public class SecurityContextHolder {

	private static ThreadLocal<HttpSession> tl = new ThreadLocal<HttpSession>();

	public static void setSession(HttpSession session) {
		tl.set(session);
	}

	public static HttpSession getSession() {
		return tl.get();
	}
}
