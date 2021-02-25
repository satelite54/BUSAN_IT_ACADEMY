package com.bit.springBoard.dao;

import java.util.ArrayList;

import com.bit.springBoard.dto.BoardDTO;

public interface IDao {
	public ArrayList<BoardDTO> listBoard();
	public BoardDTO viewBoard(int id);
	public void writeBoard(String name, String title, String content);
	public void modifyBoard(String name, String title, String content, int id);
	public void deleteBoard(int id);
	public void upHitBoard(int id);
}
