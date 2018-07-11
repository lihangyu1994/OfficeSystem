package com.lhy.office.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhy.office.entity.Role;
import com.lhy.office.mapper.RoleMapper;
import com.lhy.office.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public Role queryFunctionByRoleId(Integer roleId) {
		return roleMapper.queryFunctionByRoleId(roleId);
	}

	@Override
	public List<Role> getRoles(Role role) {
		return roleMapper.getRoles(role);
	}

	@Override
	public void updateRole(Role role) {
		roleMapper.updateRole(role);
	}

	@Override
	public void deleteRoleRight(Integer roleId) {
		roleMapper.deleteRoleRight(roleId);
	}
	
	@Override
	public void updateRoleRight(Integer roleId,Integer funids[]) {
		// 先删除原始角色原始权限
		roleMapper.deleteRoleRight(roleId);
		// 循环加入新的权限
		for(int i=0;i<funids.length;i++) {
			roleMapper.addRoleRight(roleId, funids[i]);
		}
	}

}
