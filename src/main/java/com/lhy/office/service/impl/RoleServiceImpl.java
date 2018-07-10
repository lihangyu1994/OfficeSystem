package com.lhy.office.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	public PageInfo<Role> getRolesByPaging(Role role, Integer pageNo, Integer pageCount) {
		PageHelper.startPage(pageNo, pageCount);
		List<Role> roles = roleMapper.getRoles(role);
		PageInfo<Role> pageInfo = new PageInfo<>(roles,5);
		return pageInfo;
	}

}
