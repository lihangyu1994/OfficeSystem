package com.lhy.office.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.lhy.office.entity.Log;
import com.lhy.office.service.LogService;

/**
 * 日志数据查询接口
 * @author Administrator
 *
 */
@RequestMapping("/log")
@Controller
public class LogController {
	
	@Autowired
	private LogService logService;
	
	/**
	 * 日志列表
	 * @param map
	 * @param pageNo
	 * @param pageCount
	 * @param log
	 * @return
	 */
	@RequestMapping("/logs")
	public String logs(Map<String,Object>map,
			@RequestParam(value="pageNo",defaultValue="1",required=false) Integer pageNo,
			@RequestParam(value="pageCount",defaultValue="10",required=false) Integer pageCount,Log log) {
		
			PageInfo<Log> page = null;
			if(StringUtils.hasText(log.getOptName())) {
				 page = logService.getLogsByKey(log,pageNo,pageCount);
			}else {
				 page = logService.getLogsByKey(null,pageNo,pageCount);
			}
			map.put("pageNo", pageNo);
			map.put("pageCount", pageCount);
			map.put("page", page);
			map.put("optName", log.getOptName());// 保存模糊查询条件以便回显
			
			return "log/logManage";
	}
}
