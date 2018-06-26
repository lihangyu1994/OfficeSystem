package com.lhy.office.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhy.office.entity.User;
import com.lhy.office.mapper.UserMapper;
import com.lhy.office.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	public User getUserByUsername(String username) {
		return userMapper.getUserByUsername(username);
	}

	@Override
	public User loginValidate(String loginName) {
		User user = new User();
		user.setLoginName(loginName);
		return userMapper.loginValidate(user);
	}
	
}
