package com.lhy.office.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhy.office.controller.base.AbstractController;
import com.lhy.office.dto.UserReqeust;
import com.lhy.office.entity.Institution;
import com.lhy.office.entity.Role;
import com.lhy.office.entity.User;
import com.lhy.office.service.InstitutionService;
import com.lhy.office.service.RoleService;
import com.lhy.office.service.UserService;
import com.lhy.office.util.MD5Helper;

@Controller
@RequestMapping("/User")
public class UserController extends AbstractController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private InstitutionService instService;

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
	public String modifyself(User user, Map<String, Object> map) {
		if (!StringUtils.hasText(user.getJob())) {
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
		return "/user/userview-self";
	}

	/**
	 * 调到修改密码页面
	 * @return
	 */
	@RequestMapping("/toPasswordModify")
	public String toPasswordModify() {
		return "user/usermodifypassword-self";
	}

	/**
	 * 修改用户密码
	 * @param user
	 * @param map
	 * @return
	 */
	@RequestMapping("/modifyPassword")
	public String modifyPassword(UserReqeust user, Map<String, Object> map) {

		if (!getUser().getPassword().equals(new MD5Helper().getTwiceMD5ofString(user.getOldPassword()))) {
			map.put("result", false);
			map.put("msg", "旧密码不正确");
			return "user/usermodifypassword-self";
		}
		if (getUser().getPassword().equals(new MD5Helper().getTwiceMD5ofString(user.getPassword()))) {
			map.put("result", false);
			map.put("msg", "新密码不能和旧密码相同");
			return "user/usermodifypassword-self";
		}
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			map.put("result", false);
			map.put("msg", "确认新密码必须和新密码保持一致");
			return "user/usermodifypassword-self";
		}
		User userModel = new User();
		String password = new MD5Helper().getTwiceMD5ofString(user.getConfirmPassword());
		userModel.setPassword(password);
		userModel.setUserId(getUser().getUserId());
		userService.updateUser(userModel);

		User model = getUser();
		model.setPassword(password);
		setUser(model);
		map.put("msg", "密码修改成功");
		return "/user/userview-self";
	}

	/**
	 * 客户管理列表
	 * @param map
	 * @return
	 */
	@RequestMapping("/users")
	public String users(UserReqeust userRequest, Map<String, Object> map, @RequestParam(value = "pageNo", defaultValue = "1", required = false) Integer pageNo, @RequestParam(value = "pageCount", defaultValue = "10", required = false) Integer pageCount) {

		// 引入PageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pageNo, pageCount);

		User user = new User();
		user.setUserTrueName(userRequest.getUserTrueName());
		List<User> users = userService.selectByKeyWord(user);
		PageInfo<User> page = new PageInfo<User>(users, 5);

		// 保存结果集到显示页面
		map.put("pageNo", pageNo);
		map.put("pageCount", pageCount);
		map.put("page", page);
		// 保存模糊查询条件以便回显
		map.put("userTrueName", userRequest.getUserTrueName());
		return "user/userManage";
	}

	/**
	 * 查询客户信息
	 * @param map
	 * @param userId
	 * @return
	 */
	@RequestMapping("/toView")
	public String toView(Map<String, Object> map, Integer userId) {
		User user = new User();
		user.setUserId(userId);
		User userModel = userService.getUserByKeyWord(user);
		map.put("user", userModel);
		return "user/userview";
	}

	/**
	 * 修改客户详情页面
	 * @param map
	 * @param userId
	 * @return
	 */
	@RequestMapping("/toModify")
	public String toModify(Map<String, Object> map, Integer userId) {
		
		// 查询所有未被禁用的角色
		Role role = new Role();
		role.setRoleState(1);
		List<Role> roles = roleService.getRoles(role);
		map.put("roleList", roles);
		
		// 查询所有未被禁用的机构
		Institution institution = new Institution();
		institution.setInstState(1);
		List<Institution> institutions = instService.getInstitutions(institution);
		map.put("institutionList", institutions);
		
		// 查询客户信息
		User user = new User();
		user.setUserId(userId);
		User userModel = userService.getUserByKeyWord(user);
		map.put("user", userModel);
		
		return "user/usermodify";
	}
	/**
	 * 修改客户信息
	 * @param user
	 * @param map
	 * @return
	 */
	@RequestMapping("/modify")
	public String modify(User user,Map<String,Object>map) {
		if(userService.getUserByUsername(user.getLoginName())!=null) {
			map.put("result", false);
			map.put("msg", "用户名已存在");
			return "user/usermodify";
		}
		if(StringUtils.hasText(user.getPassword())) {
			String password = new MD5Helper().getTwiceMD5ofString(user.getPassword());
			user.setPassword(password);
		}
		userService.updateUser(user);
		map.put("result", true);
		map.put("msg", "用户信息修改成功");
		return "forward:/User/users";
	}
}
