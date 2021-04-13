package com.satelite54.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor{
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long start = System.currentTimeMillis();
		
		Object result = invocation.proceed();
		
		Thread.sleep(200);
		
		long end = System.currentTimeMillis();
		String message = (end - start) + "ms �ð��� �ɷȽ��ϴ�.";
		System.out.println(message);
		return result;
	}
}
