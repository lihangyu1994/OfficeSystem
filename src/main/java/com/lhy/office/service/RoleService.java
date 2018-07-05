package com.lhy.office.service;

import java.util.List;

import com.lhy.office.entity.Role;

/**
 * 角色查询接口
 * @author Administrator
 *
 */
public interface RoleService {
	/**
	 * 查询角色的功能
	 * @param roleId
	 * @return
	 */
	public Role queryFunctionByRoleId(Integer roleId);
	/**
	 * 查询角色信息
	 * @param role
	 * @return
	 */
	public List<Role> getRoles(Role role); 
}
