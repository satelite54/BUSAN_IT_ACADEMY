package org.satelite54._8;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListenerEx implements ServletContextListener{//�����ø����̼� ���� Ŭ����
	public ContextListenerEx() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {// �� ���ø����̼��� ����� �� ����
		System.out.println("contextDestroyed");
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) {// �� ���ø����̼��� ����� �� ����
		System.out.println("contextInitalized");
	}
}
