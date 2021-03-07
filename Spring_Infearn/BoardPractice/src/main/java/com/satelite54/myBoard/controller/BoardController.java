package com.satelite54.myBoard.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.satelite54.myBoard.model.board.dao.BoardDAO;
import com.satelite54.myBoard.model.board.dto.BoardDTO;

@Controller
public class BoardController {
	
	@RequestMapping(value = "/")
	private String goBoardWithUserList(Model model) {
		ClassPathXmlApplicationContext factory
		= new ClassPathXmlApplicationContext("../spring/root-context.xml");
		
		BoardDAO boardDao = (BoardDAO) factory.getBean("boardDAO");
		List<BoardDTO> boardList = boardDao.getBoardList();
		model.addAttribute("BoardList", boardList);
		return "community";
	}
}
