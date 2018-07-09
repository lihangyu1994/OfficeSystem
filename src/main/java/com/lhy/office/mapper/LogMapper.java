package com.lhy.office.mapper;

import java.util.List;

import com.lhy.office.entity.Log;

public interface LogMapper {

	/**
	 * 根据条件查询日志
	 * @param log
	 * @return
	 */
	public List<Log> getLogsByKey(Log log);
}
