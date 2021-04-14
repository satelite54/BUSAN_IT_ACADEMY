package com.satelite54.aop;

import org.springframework.aop.ThrowsAdvice;

public class LogAfterThrowingAdvice implements ThrowsAdvice{
	//ThrowsAdvice는 필수로 구현해야하는 매소드가 없다.
	//왜냐 실행 매소드에서 무슨 예외를 던질지 모르기 때문
	public void afterThrowing(IllegalArgumentException e) throws Throwable {
		System.out.println("예외가 발생했습니다. Msg : " + e.getMessage());
	}
}
