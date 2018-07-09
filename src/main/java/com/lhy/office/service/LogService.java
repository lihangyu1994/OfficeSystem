package com.lhy.office.service;

import com.github.pagehelper.PageInfo;
import com.lhy.office.entity.Log;

public interface LogService {
	
	/**
	 * 根据条件查询日志
	 * @param log
	 * @return
	 */
	public PageInfo<Log> getLogsByKey(Log log,Integer pageNo,Integer pageCount);

}
