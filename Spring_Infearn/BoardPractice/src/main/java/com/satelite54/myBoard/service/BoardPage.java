package com.satelite54.myBoard.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class BoardPage {
	private int pageStartNum;
	private int pageEndNum;
	private int blockStartNum;
	private int blockEndNum;
	private int totalPageNum;
	private int curPage;
	
	public BoardPage() {}
	
	public void setBoardPage(int blockEndNum, int curPage, int PageNationCnt) {
		
	}
}

