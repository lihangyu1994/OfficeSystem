package com.lhy.office.mapper;

import java.util.List;

import com.lhy.office.entity.User;

public interface UserMapper {
	/**
	 * 通过用户名查询客户
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username);
	/**
	 * 查询客户
	 * @param user
	 * @return
	 */
	public User getUserByKeyWord(User user);
	/**
	 * 修改客户信息
	 * @param user
	 */
	public void updateUser(User user);
	/**
	 * 查询客户列表
	 * @param user
	 * @return
	 */
	public List<User> selectByKeyWord(User user);
}

