package com.lhy.office.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhy.office.controller.base.AbstractController;
import com.lhy.office.entity.Institution;
import com.lhy.office.service.InstitutionService;

/**
 * 机构信息
 * @author Administrator
 *
 */
@RequestMapping("/institution")
@Controller
public class InstitutionController extends AbstractController{

	@Autowired
	private InstitutionService instittutionService;
	/**
	 * 机构查询
	 * @param map
	 * @param institution
	 * @param pageNo
	 * @param pageCount
	 * @return
	 */
	@RequestMapping("/institutions")
	public String institutions(Map<String,Object>map,Institution institution,
				@RequestParam(value="pageNo",defaultValue="1",required=false)Integer pageNo,
				@RequestParam(value="pageCount",defaultValue="10",required=false)Integer pageCount) {
				
		PageHelper.startPage(pageNo,pageCount);
		List<Institution> list = instittutionService.getInstitutions(institution);
		PageInfo<Institution> page = new PageInfo<>(list,5);
		
		map.put("page", page);
		return "institution/institutionManage";
	}
}
