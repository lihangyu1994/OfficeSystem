package com.lhy.office.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/fun")
@Controller
public class FunctionController {

	@RequestMapping("/funs")
	public String  getList() {
		
		return "";
	}
}
