package com.lhy.office.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhy.office.constants.Constants;
import com.lhy.office.controller.base.AbstractController;
import com.lhy.office.dto.UserReqeust;
import com.lhy.office.entity.Function;
import com.lhy.office.entity.User;
import com.lhy.office.service.RoleService;
import com.lhy.office.service.UserService;
import com.lhy.office.util.CodeUtil;
import com.lhy.office.util.MD5Helper;

@Controller
public class LoginController extends AbstractController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	/*@Autowired
	private ArticleService articleService;*/

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

	/**
	 * 客户登录
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String users(Map<String, Object> map, UserReqeust request) {
		if (!StringUtils.hasText(request.getLoginName())) {
			map.put("msg", "登录名不能为空");
			map.put("result", false);
		}
		if (!StringUtils.hasText(request.getPassword())) {
			map.put("msg", "密码不能为空");
			map.put("result", false);
		}
		if (!StringUtils.hasText(request.getCode())) {
			map.put("msg", "验证码不能为空");
			map.put("result", false);
		}
		if (!request.getCode().equalsIgnoreCase((String) getSession().getAttribute("code"))) {
			map.put("msg", "验证码不正确");
			map.put("result", false);
		}
		User user = new User();
		user.setLoginName(request.getLoginName());
		User userModel = userService.getUserByKeyWord(user);
		if (userModel == null) {
			map.put("msg", "客户不存在");
			map.put("result", false);
			return "login";
		}
		MD5Helper md5Helper = new MD5Helper();
		if (!md5Helper.getTwiceMD5ofString(request.getPassword()).equals(userModel.getPassword())) {
			map.put("msg", "密码不正确");
			map.put("result", false);
		} else {
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
	public String toIndex(Map<String,Object> map) {
		int roleId = getUser().getRoleId();
		List<Function> functions = roleService.queryFunctionByRoleId(roleId).getFunctionList();
		map.put("functionList", functions);
		// 用户的角色信息
		return "index";
	}
	
	/**
	 * 访问欢迎页
	 * @param map
	 * @return
	 */
	@RequestMapping("/toWelcome")
	public String toWelcome(Map<String, Object> map, HttpSession session) {

		//1.从Session中取出用户信息，并得到用户id和角色id
		Integer userId = getUser().getUserId();
		Integer roleid = getUser().getRoleId();

		//2.找出要统计的4个数字

		//2.1 找出待处理公文数量
/*		Long dealcount = null;
		if (roleid == 1 || roleid == 2) {
			dealcount = articleService.getDealCount(userId);
		}

		//2.2 找出审核驳回公文数量
		Long failcount = articleService.getFailCount(userId);

		//2.3 找出待接收公文数量
		Long receivecount = articleService.getReceivedCount(userId);

		//2.4 找出等待审核通过公文数量
		Long waitcount = articleService.getWaitCount(userId);*/

		//3 保存查询结果
		map.put("dealcount", 1);
		map.put("failcount", 2);
		map.put("receivecount", 3);
		map.put("waitcount",4);

		//4.返回首页
		return "home";
	}
}
