package com.lhy.office.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhy.office.entity.User;
import com.lhy.office.mapper.UserMapper;
import com.lhy.office.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public User getUserByUsername(String username) {
		return userMapper.getUserByUsername(username);
	}

	@Override
	public User getUserByKeyWord(User user) {
		return userMapper.getUserByKeyWord(user);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Override
	public List<User> selectByKeyWord(User user) {
		return userMapper.selectByKeyWord(user);
	}

	@Override
	public void add(User user) {
		userMapper.add(user);
	}

}
