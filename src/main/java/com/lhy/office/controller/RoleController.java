package com.lhy.office.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhy.office.entity.Role;
import com.lhy.office.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
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
}
