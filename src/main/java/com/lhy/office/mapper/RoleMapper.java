package com.lhy.office.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

	/**
	 * 删除角色拥有功能
	 * @param roleId
	 */
	public void deleteRoleRight(Integer roleId);

	/**
	 * 角色新增权限
	 * @param roleId
	 * @param funId
	 */
	public void addRoleRight(@Param("roleId") Integer roleId, @Param("funId") Integer funId);

	/**
	 * 新增角色
	 * @param role
	 */
	public void addRole(Role role);
}
