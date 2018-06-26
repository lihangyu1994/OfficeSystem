package com.lhy.office.service.impl;

import org.springframework.stereotype.Service;

import com.lhy.office.entity.Role;
import com.lhy.office.mapper.RoleMapper;
import com.lhy.office.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	private RoleMapper roleMapper;
	
	@Override
	public Role queryFunctionByRoleId(Integer roleId) {
		return roleMapper.queryFunctionByRoleId(roleId);
	}

}