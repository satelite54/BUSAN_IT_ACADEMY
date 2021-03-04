package com.satelite54.myServiceDao.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class memberController {
	
	@RequestMapping(value = "")
	private void memJoin(Model model, HttpServletRequest request) {
		
	}
}
