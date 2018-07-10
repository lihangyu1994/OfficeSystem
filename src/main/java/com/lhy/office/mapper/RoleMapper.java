package com.lhy.office.mapper;

import java.util.List;

import com.lhy.office.entity.Role;

/**
 * 角色数据查询接口
 * @author Administrator
 *
 */
public interface RoleMapper {
	/**
	 * 查询角色的功能
	 * @param roleId
	 * @return
	 */
	public Role queryFunctionByRoleId(int roleId);
	/**
	 * 查询角色信息
	 * @param role
	 * @return
	 */
	public List<Role> getRoles(Role role); 
	/**
	 * 角色管理
	 * @param role
	 * @return
	 */
	public List<Role> getRolesByPage(Role role);
	/**
	 * 修改角色信息
	 * @param role
	 */
	public void updateRole(Role role);
}
