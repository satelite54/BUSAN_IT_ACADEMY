package com.satelite54.myBoard.service;

import java.util.List;

import com.satelite54.myBoard.model.board.dto.BoardDTO;

public interface IBoardService {
	public List<BoardDTO> getBoardPageList(int boardStartNum, int boardEndNum, String title);
	public int getTotalBoardCnt();
}
