package com.lhy.office.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhy.office.dto.UserReqeust;
import com.lhy.office.entity.Log;
import com.lhy.office.entity.User;
import com.lhy.office.mapper.LogMapper;
import com.lhy.office.service.LogService;
@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogMapper logMapper;
	
	@Override
	public PageInfo<Log> getLogsByKey(Log log,Integer pageNo,Integer pageCount) {
		
		PageHelper.startPage(pageNo, pageCount);
		List<Log> logs = logMapper.getLogsByKey(log);
		PageInfo<Log> page  = new PageInfo<Log>(logs,5);
		return  page;
	}

}
