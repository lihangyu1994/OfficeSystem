package com.lhy.office.mapper;

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
}
