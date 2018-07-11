package com.lhy.office.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhy.office.entity.Function;
import com.lhy.office.mapper.FunctionMapper;
@Service
public class FunctionService implements com.lhy.office.service.FunctionService {

	@Autowired
	private FunctionMapper functionMapper; 
	@Override
	public List<Function> getFunctions(Function function) {
		return functionMapper.getFunctions(function);
	}

}
