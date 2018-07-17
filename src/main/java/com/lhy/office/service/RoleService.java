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
	 * 查询角色
	 * @param role
	 * @param pageNo
	 * @param pageCount
	 * @return
	 */
	public List<Role> getRoles(Role role);

	/**
	 * 修改角色信息
	 * @param role
	 */
	public void updateRole(Role role);

	/**
	 * 删除角色拥有功能
	 * @param roleId
	 */
	public void deleteRoleRight(Integer roleId);

	/**
	 * 修改角色拥有功能
	 * @param roleId
	 * @param funids
	 */
	public void updateRoleRight(Integer roleId, Integer funids[]);

	/**
	 * 新增角色
	 * @param role
	 */
	public void addRole(Role role);
}
