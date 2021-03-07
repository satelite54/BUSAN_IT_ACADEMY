package com.satelite54.myBoard.model.board.dao;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.satelite54.myBoard.model.board.dto.BoardDTO;

import lombok.Setter;

@Repository
@Setter
public class BoardDAOImpl implements BoardDAO {
	@Inject
	private SqlSessionTemplate sqlSession;
	
	private static final String NAMESPACE = "com.satelite54.myBoard.model.";
	
	@Override
	public Date test() {
		return sqlSession.selectOne(NAMESPACE + "getTime");
	}
	@Override
	public  List<BoardDTO> getBoardList() {
		List<BoardDTO> userList = sqlSession.selectList("getBoardList");
		return userList;
	}
}
