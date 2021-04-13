package com.satelite54.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.satelite54.aop.entity.Exam;

public class Program {
	public static void main(String args[]) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/satelite54/aop/config/setting.xml");
		
		Exam exam = (Exam) context.getBean("exam");
		
		System.out.printf("total is %d\n", exam.total());
		System.out.printf("avg is %f\n", exam.avg());
	}
}
