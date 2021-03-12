package com.satelite54.myBoard.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.satelite54.myBoard.model.board.dao.IBoardDAO;
import com.satelite54.myBoard.model.board.dto.BoardDTO;

@Service
public class BoardServiceImpl implements IBoardService {

	@Inject
	IBoardDAO boardDAO;
	
	public List<BoardDTO> getBoardPageList(int pageNum, String title) {
		int boardStartNum = 1;
		int boardEndNum = 20;
		List<BoardDTO> SearchBoardList = boardDAO.getBoardPageList(boardStartNum,boardEndNum, title);
		return SearchBoardList;
	}
}
