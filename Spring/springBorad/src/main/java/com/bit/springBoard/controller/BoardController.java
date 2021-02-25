package com.bit.springBoard.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.springBoard.dao.IDao;

@Controller
public class BoardController {
	
	@Autowired
	private	SqlSession sqlSession;
	
	@RequestMapping(value = "writeView")
	public String writeView() {return "writeView";}
	
	@RequestMapping(value = "list")
	public String list(Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.listBoard()); // ArrayList<BoardDTO>�� LIst ����������  model ����
		return "list";
	}
	
	@RequestMapping(value = "contentView")
	public String contentView(int id, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.upHitBoard(id);
		model.addAttribute("contentView", dao.viewBoard(id));
		return "contentView";
	}
	
	@RequestMapping(value = "write")
	//writeView.jsp���� name ���� �Ű� ������ �����ϸ� �ڵ������� ����
	public String write( String name, String title, String content) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.writeBoard(name, title, content);
		return"redirect:list";
	}
	
	@RequestMapping(value = "modify")
	public String modify(String name, String title, String content, int id) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.modifyBoard(name, title, content, id);
		return "redirect:list";
	}
	
	@RequestMapping(value = "delete")
	public String delete(int id) {
		return "redirect:list";
	}
}
