package com.lhy.office.controller.base;

import javax.servlet.http.HttpSession;

import com.lhy.office.constants.Constants;
import com.lhy.office.entity.User;
import com.lhy.office.filter.SecurityContextHolder;

/**
 * 业务通用
 * @author Administrator
 *
 */
public abstract class AbstractController {

	/**
	 * @return 当前session
	 */
	protected static final HttpSession getSession() {
		return SecurityContextHolder.getSession();
	}

	/**往session中注入参数*/
	protected void setSessionParam(String key, Object param) {
		getSession().setAttribute(key, param);
	}

	/**获取当前用户*/
	protected static User getUser() {
		return (User) getSession().getAttribute(Constants.SESSION_CUSTOMER_INFO);
	}

	/**客户存入session*/
	protected static void setUser(User user) {
		getSession().setAttribute(Constants.SESSION_CUSTOMER_INFO, user);
	}

}
