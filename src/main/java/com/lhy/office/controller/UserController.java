package com.lhy.office.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lhy.office.controller.base.AbstractController;
import com.lhy.office.entity.User;
import com.lhy.office.service.UserService;

@Controller
@RequestMapping("/User")
public class UserController extends AbstractController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 客户基本信息
	 * @return
	 */
	@RequestMapping("/viewSelf")
	public String viewSelf() {
		return "/user/userview-self";
	}
	/**
	 * 跳转客户信息修改页面
	 * @return
	 */
	@RequestMapping("/toModifySelf")
	public String toModifySelf() {
		return "/user/usermodify-self";
	}
	/**
	 * 修改客户基本信息
	 * @param user
	 * @param map
	 * @return
	 */
	@RequestMapping("/modifyself")
	public String modifyself(User user,Map<String, Object> map) {
		if(!StringUtils.hasText(user.getJob())) {
			map.put("result", false);
			map.put("msg", "职务不能为空");
			return "/user/usermodify-self";
		}
		user.setUserId(getUser().getUserId());
		userService.updateUser(user);
		
		User model = new User();
		model.setUserId(getUser().getUserId());
		model = userService.getUserByKeyWord(model);
		setUser(model);
		return "forward:/User/viewSelf";
	}
}
