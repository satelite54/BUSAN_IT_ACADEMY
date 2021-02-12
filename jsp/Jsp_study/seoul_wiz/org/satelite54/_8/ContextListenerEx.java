package org.satelite54._8;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListenerEx implements ServletContextListener{//웹어플리케이션 감시 클래스
	public ContextListenerEx() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {// 웹 애플리케이션이 종료될 때 동작
		System.out.println("contextDestroyed");
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) {// 웹 애플리케이션이 실행될 때 동작
		System.out.println("contextInitalized");
	}
}
