package com.lhy.office.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhy.office.controller.base.AbstractController;
import com.lhy.office.entity.User;
import com.lhy.office.service.UserService;
import com.lhy.office.util.CodeUtil;
import com.lhy.office.util.GsonUtil;
@Controller
@RequestMapping("/login")
public class LoginController extends AbstractController{
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/captcha",method=RequestMethod.GET)
	@ResponseBody
	public void captcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CodeUtil.drawCode(request, response);
	}

	@RequestMapping("/login")
	@ResponseBody
	public String users(User user) {
		User userModel = userService.getUserByUsername(user.getLoginName());
		return GsonUtil.GsonString(userModel);
	}
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
}
