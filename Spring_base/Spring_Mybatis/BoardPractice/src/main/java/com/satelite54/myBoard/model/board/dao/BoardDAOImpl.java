package com.satelite54.myBoard.model.board.dao;

import java.sql.Date;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.satelite54.myBoard.model.";
	
	@Override
	public Date test() {
		return sqlSession.selectOne(NAMESPACE + "getTime");
	}
}
