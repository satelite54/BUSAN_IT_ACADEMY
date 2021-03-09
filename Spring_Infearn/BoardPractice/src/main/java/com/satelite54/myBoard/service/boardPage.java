package com.satelite54.myBoard.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.satelite54.myBoard.model.board.dao.BoardDAO;
import com.satelite54.myBoard.model.board.dto.BoardDTO;

@Service
public class boardPage {

	@Inject
	BoardDAO boardDAO;
	
	public List<BoardDTO> getBoardPageList(int pageNum) {
		ClassPathXmlApplicationContext factory
		= new ClassPathXmlApplicationContext("../spring/root-context.xml");
		
		BoardDAO boardDao = (BoardDAO) factory.getBean("boardDAO");
		List<BoardDTO> SearchBoardList = boardDao.getBoardPageList(1, "Title");
		
		return SearchBoardList;
	}
}
