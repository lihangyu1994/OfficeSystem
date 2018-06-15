package com.lhy.office.mapper;

import com.lhy.office.entity.User;

public interface UserMapper {
	/**
	 * 通过用户名查询客户
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username);
}

