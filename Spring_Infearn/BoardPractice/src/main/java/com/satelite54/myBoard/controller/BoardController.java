package com.satelite54.myBoard.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.satelite54.myBoard.model.board.dto.BoardDTO;
import com.satelite54.myBoard.service.BoardPage;
import com.satelite54.myBoard.service.BoardServiceImpl;

@Controller
public class BoardController {

	@Inject
	BoardServiceImpl boardService;

	@RequestMapping(value = "/")
	private String goBoardWithUserList(Model model,
			@RequestParam("curPage") String curPage,
			@RequestParam("pageSize") String pageSize,
			@RequestParam("search") String search) {
		List<BoardDTO> boardList = boardService.getBoardPageList(10, 20, search);

		BoardPage page = new BoardPage();
		int PageNum = Integer.parseInt(curPage);
		page.setPageNo(PageNum);
		page.setPageSize(5);//pageSize
		page.setTotalCount(boardService.getTotalBoardCnt());
		model.addAttribute("Page", page);
		model.addAttribute("BoardList", boardList);
		return "community";
	}
}
