package com.satelite54.myBoard.model.board.dao;

import java.sql.Date;
import java.util.List;

import com.satelite54.myBoard.model.board.dto.BoardDTO;

public interface BoardDAO {
	public Date test();
	public List<BoardDTO> getBoardList();
}
