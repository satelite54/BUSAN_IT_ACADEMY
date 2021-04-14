package com.satelite54.aop;

import org.springframework.aop.ThrowsAdvice;

public class LogAfterThrowingAdvice implements ThrowsAdvice{
	//ThrowsAdvice�� �ʼ��� �����ؾ��ϴ� �żҵ尡 ����.
	//�ֳ� ���� �żҵ忡�� ���� ���ܸ� ������ �𸣱� ����
	public void afterThrowing(IllegalArgumentException e) throws Throwable {
		System.out.println("���ܰ� �߻��߽��ϴ�. Msg : " + e.getMessage());
	}
}
