package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterService {
	// @Resource 와 @Autowired의 차이는 객체를 찾는 방법, 생성자에 사용할 수 있나 없나 차이가 있다.
	// @Resource는 객체의 이름을 보고 찾아 스프링 컨테이너에 의존 주입하고 @Autowired는 객체의 타입을 보고 찾아 IOC 컨테이너에 의존 주입한다.
	@Autowired // 프로퍼티나 메소드에 @Autowired 어노테이션 사용시 디폴트 생성자 명시해줘야함
	// 객체가 생성이 되어야지 스프링 컨테이너에 넣을 수 있기 때문에
//	@Qualifier("usedDao")
	// @Qualifier 스프링 컨테이너 객체에서 Qualifier태그에 지정된 value값을 참조해 객체를 찾는다.
	//@Qualifier의 id 속성 값과 변수명이 같은때는 Qualifier를 생략 가능하다. 좋은 방법이 아니다. 여러개 객체가 생성되면 가발자가 혼동할 수도 있기 때문에
	//@Inject의 경우 requird 속성이 없다 그거 말고는 @Autowired랑 똑같음
	private WordDao wordDao;
	
	public WordRegisterService() {}
	@Autowired
	public WordRegisterService(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The wird has alredy registered");
		}
	}
	
	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}
	
	@Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
}
