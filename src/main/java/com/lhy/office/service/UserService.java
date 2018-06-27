package com.lhy.office.service;

import com.lhy.office.entity.User;

public interface UserService {

	/**
	 * 通过用户名查询客户
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username);
	/**
	 * 查询客户信息
	 * @param user
	 * @return
	 */
	public User getUserByKeyWord(User user);
	/**
	 * 修改客户信息
	 * @param user
	 */
	public void updateUser(User user);
}

