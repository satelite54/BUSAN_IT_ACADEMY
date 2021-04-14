package com.satelite54.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfterReturningAdvice implements AfterReturningAdvice{
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.append("returnValue:").append(returnValue.toString()).append(", method:").append(method.getName()));
	}
}
