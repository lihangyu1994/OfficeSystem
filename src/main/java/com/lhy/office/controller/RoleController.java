package com.lhy.office.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.lhy.office.entity.Role;
import com.lhy.office.service.RoleService;

@RequestMapping("/role")
@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/roles")
	public String getRoles(Map<String,Object>map,
			@RequestParam(value="pageNo",defaultValue="1",required=false)Integer pageNo,
			@RequestParam(value="pageCount",defaultValue="10",required=false)Integer pageCount,
			Role role) {
		
		PageInfo<Role> page= roleService.getRolesByPaging(role, pageNo, pageCount);
		map.put("pageNo", pageNo);
		map.put("pageCount", pageCount);
		map.put("page", page);
		map.put("roleId", "roleId");
		return "role/roleManage";
	}
}
