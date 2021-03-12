package com.satelite54.myBoard.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.satelite54.myBoard.model.board.dto.BoardDTO;
import com.satelite54.myBoard.service.BoardServiceImpl;

@Controller
public class BoardController {
	
	@Inject
	BoardServiceImpl boardService;
	
	@RequestMapping(value = "/")
	private String goBoardWithUserList(Model model) {
		List<BoardDTO> boardList = boardService.getBoardPageList(5, "title");
		model.addAttribute("BoardList", boardList);
		return "community";
	}
}
