package com.lhy.office.service;

import com.lhy.office.entity.Role;

/**
 * 角色查询接口
 * @author Administrator
 *
 */
public interface RoleService {
	
	public Role queryFunctionByRoleId(Integer roleId);
}
