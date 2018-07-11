package com.lhy.office.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhy.office.entity.Function;
import com.lhy.office.entity.Role;
import com.lhy.office.service.FunctionService;
import com.lhy.office.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private FunctionService functionService;
	
	@RequestMapping("/roles")
	public String getRoles(Map<String,Object>map,
			@RequestParam(value="pageNo",defaultValue="1",required=false)Integer pageNo,
			@RequestParam(value="pageCount",defaultValue="10",required=false)Integer pageCount,Role role) {
		
		PageHelper.startPage(pageNo,pageCount);
		List<Role> roles = roleService.getRoles(role);
		PageInfo<Role> page = new PageInfo<Role>(roles,5);
		
		map.put("pageNo", pageNo);
		map.put("pageCount", pageCount);
		map.put("page", page);
		map.put("allList", roleService.getRoles(null));
		//保存模糊查询条件以便回显
		map.put("role_id", role.getRoleId());
		return "role/roleManage";
	}
	
	/**
	 * 设置角色信息页面
	 * @param roleid
	 * @param map
	 * @return
	 */
	@RequestMapping("/toModify")
	public String toModify(Integer roleid,Map<String,Object>map) {
		Role role = new Role();
		role.setRoleId(roleid);
		List<Role> roles = roleService.getRoles(role);
		if(roles!=null&&roles.size()>0) {
			map.put("role", roles.get(0));
		}
		return "role/rolemodify";
	}
	/**
	 * 修改角色信息
	 * @param role
	 * @param map
	 * @return
	 */
	@RequestMapping("/modifyRole")
	public String modifyRole(Role role,Map<String,Object>map) {
		roleService.updateRole(role);
		return "redirect:/role/roles";
	}
	/**
	 * 去设置权限
	 * @param userid
	 * @param map
	 * @return
	 */
	@RequestMapping("/toRoleRight")
	public String toRoleRight(Integer roleid,Map<String,Object>map) {
		
		Role role = roleService.queryFunctionByRoleId(roleid);
		map.put("role", role);
		
		List<Function> functionList = functionService.getFunctions(null);
		map.put("functionList", functionList);
		
		return "role/roleright";
	}
	/**
	 * 修改权限
	 * @param map
	 * @param roleId
	 * @param funids
	 * @return
	 */
	@RequestMapping("/updateRoleRight")
	public String updateRoleRight(Map<String,Object>map,Integer roleId,Integer[]funids) {
		roleService.updateRoleRight(roleId, funids);
		return "redirect:/role/roles";
	}
	/**
	 * 跳转到新增角色页面
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "role/roleadd";
	}
	/**
	 * 新增角色
	 * @param map
	 * @param role
	 * @return
	 */
	@RequestMapping("/addRole")
	public String addRole(Map<String,Object>map,Role role) {
		roleService.addRole(role);
		return "redirect:/role/roles";
	}
}
