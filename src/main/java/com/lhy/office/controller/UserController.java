package com.lhy.office.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhy.office.entity.User;
import com.lhy.office.service.UserService;
import com.lhy.office.util.GsonUtil;

@Controller
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	private UserService userService;

/*	@RequestMapping("/findAll")
	@ResponseBody
	public String users(User user) {
		User userModel = userService.getUserByUsername(user.getLoginName());
		return GsonUtil.GsonString(userModel);
	}
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}*/
	
	@RequestMapping("/viewSelf")
	public String viewSelf() {
		return "/user/userview-self";
	}
}
