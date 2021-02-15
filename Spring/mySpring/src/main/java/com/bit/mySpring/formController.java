package com.bit.mySpring;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class formController {
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String list(HttpServletRequest request, Model model) {
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String name = request.getParameter("name");
		model.addAttribute("name", name);
		return "list";
	}
}
