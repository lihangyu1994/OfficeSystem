package com.lhy.office.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhy.office.constants.Constants;
import com.lhy.office.controller.base.AbstractController;
import com.lhy.office.dto.UserReqeust;
import com.lhy.office.entity.User;
import com.lhy.office.service.UserService;
import com.lhy.office.util.CodeUtil;
import com.lhy.office.util.MD5Helper;

@Controller
public class LoginController extends AbstractController {

	@Autowired
	private UserService userService;

	/**
	 * 验证码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/captcha", method = RequestMethod.GET)
	@ResponseBody
	public void captcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CodeUtil.drawCode(request, response);
	}

	@RequestMapping("/login")
	public String users(Map<String, Object> map,UserReqeust request) {
		if(!StringUtils.hasText(request.getLoginName())) {
			map.put("msg", "登录名不能为空");
			map.put("result", false);
		}
		if(!StringUtils.hasText(request.getPassword())) {
			map.put("msg", "密码不能为空");
			map.put("result", false);
		}
		if(!StringUtils.hasText(request.getCode())) {
			map.put("msg", "验证码不能为空");
			map.put("result", false);
		}
		if(!request.getCode().equalsIgnoreCase((String) getSession().getAttribute("code"))) {
			return "验证码不正确";
		}
		User userModel = userService.getUserByUsername(request.getLoginName());
		if(userModel==null) {
			map.put("msg", "客户不存在");
			map.put("result", false);
			return "login";
		}
		MD5Helper md5Helper = new MD5Helper();
		if(!md5Helper.getTwiceMD5ofString(request.getPassword()).equals(userModel.getPassword())) {
			map.put("msg", "密码不正确");
			map.put("result", false);
		}else {
			setSessionParam(Constants.SESSION_CUSTOMER_INFO, userModel);
			return "forward:/toIndex";
		}
		return "login";
	}

	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	@RequestMapping("/toIndex")
	public String toIndex() {
		User user = getUser();
		return "index";
	}
}
