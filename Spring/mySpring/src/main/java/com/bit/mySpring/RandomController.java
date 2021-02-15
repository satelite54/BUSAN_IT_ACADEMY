package com.bit.mySpring;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RandomController {
	
	@RequestMapping(value = "/random")
	public String random(Model model) {
		Random rd = new Random();
		int luckey = rd.nextInt(45) + 1;
		model.addAttribute("Lucky", luckey);
		return "random";// views/random.jsp 호출
	}
}
