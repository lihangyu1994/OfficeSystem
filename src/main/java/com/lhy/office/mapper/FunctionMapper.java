package com.lhy.office.mapper;

import java.util.List;

import com.lhy.office.entity.Function;

/**
 * 功能查询接口
 * @author Administrator
 *
 */
public interface FunctionMapper {

	/**
	 * 查询功能列表
	 * @param function
	 * @return
	 */
	public List<Function> getFunctions(Function function);
}
