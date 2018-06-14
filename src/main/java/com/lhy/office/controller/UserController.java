package com.lhy.office.controller;

import java.util.List;

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

	@RequestMapping("/findAll")
	@ResponseBody
	public String users() {
		List<User> list = userService.users(1);
		return GsonUtil.GsonString(list);
	}
}
