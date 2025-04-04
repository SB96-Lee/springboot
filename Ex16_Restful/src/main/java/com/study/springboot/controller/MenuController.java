package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.service.MenuService;

@Controller
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping("/menuForm")
	public String menuForm() {
		return "menu/menuForm";
	}
}
