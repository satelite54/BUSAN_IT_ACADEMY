package com.bit.mySpring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dto.MemberDto;

@Controller
public class MemberController {

	@RequestMapping(value = "member/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping(value = "member/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	@RequestMapping(value = "member/confirmId")
	public String confirmId(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		return "member/confirmId";
	}
	
	@RequestMapping(value = "member/confirmId1")
	public String confirmId(@RequestParam("id") String id,
			@RequestParam("pwd") String pwd,
			Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		return "member/confirmId";
	}
	
	@RequestMapping("member/join")
	public String join(@RequestParam("id") String id,
			@RequestParam("pwd") String pwd,
			@RequestParam("name") String name,
			@RequestParam("email") String email, Model model) {
			
		MemberDto dto = new MemberDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setEmail(email);
		
		model.addAttribute("member", dto);
		
		return "member/join";
	}
	
	@RequestMapping("member/join1")
	// 자동적으로 DTO 객체를 생성하고 setter호출
	// model.addAttribute("member" , member);
	public String join(@ModelAttribute("member") MemberDto member) {
		return "member/join";
	}
	
	@RequestMapping(value = "member/student/{studentId}/{num}")
	public String student(@PathVariable String studentId,
				@PathVariable int num, Model model) {
		model.addAttribute("studentId", studentId);
		model.addAttribute("num", num);
		return "member/student";
	}
	
	@RequestMapping("member/getPostForm")
	public String getPostForm() {
		return "member/getPostForm";
	}
	
	@RequestMapping("member/goGet")
	public String goGet(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		model.addAttribute("id", id);
		return "member/goGet";
	}
	@RequestMapping(value = "member/goPost", method=RequestMethod.POST)
	public ModelAndView goPost(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String id = req.getParameter("id");
		mv.addObject("id", id);
		mv.setViewName("member/goGet");
		return mv;
	}
}

