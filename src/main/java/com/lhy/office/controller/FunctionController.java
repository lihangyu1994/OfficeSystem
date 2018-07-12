package com.lhy.office.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhy.office.entity.Function;
import com.lhy.office.service.FunctionService;

@RequestMapping("/fun")
@Controller
public class FunctionController {

	@Autowired
	private FunctionService functionService;
	
	/**
	 * 功能列表
	 * @param map
	 * @param function
	 * @param pageNo
	 * @param pageCount
	 * @return
	 */
	@RequestMapping("/funs")
	public String  getList(Map<String,Object>map,Function function,
						@RequestParam(value="pageNo",defaultValue="1",required=false)Integer pageNo,
						@RequestParam(value="pageCount",defaultValue="10",required=false)Integer pageCount) {
		PageHelper.startPage(pageNo, pageCount);
		List<Function> functions = null;
		if(StringUtils.hasText(function.getFunName())) {
			functions = functionService.getFunctionList(function);
		}else {
			functions = functionService.getFunctionList(null);
		}
		
		PageInfo<Function> page = new PageInfo<Function>(functions,5);
		
		map.put("page", page);
		map.put("pageNo", pageNo);
		map.put("pageCount", pageCount);
		map.put("funName", function.getFunName());
		return "function/functionManage";
	}
	
	/**禁用功能
	 * @param map
	 * @param funid
	 * @return
	 */
	@RequestMapping("/disable")
	public String disable(Map<String,Object>map,Integer funid) {
		Function function = new Function();
		function.setFunState(0);
		function.setFunId(funid);
		functionService.updateFunction(function);
		return "redirect:/fun/funs";
	}
	
	/**
	 * 启动功能
	 * @param map
	 * @param funid
	 * @return
	 */
	@RequestMapping("/enable")
	public String enable(Map<String,Object>map,Integer funid) {
		Function function = new Function();
		function.setFunState(1);
		function.setFunId(funid);
		functionService.updateFunction(function);
		return "redirect:/fun/funs";
	}
	
	
}
