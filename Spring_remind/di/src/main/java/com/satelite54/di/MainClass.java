package com.satelite54.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.satelite54.di.config.NewlecAppConfig;
import com.satelite54.di.entity.NewlecExam;
import com.satelite54.di.ui.ExamConsole;
import com.satelite54.di.ui.InlineExamConsole;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Exam exam = new NewlecExam();
//		ExamConsole console = new lnlineExamConsole(exam);
//		ExamConsole console = new GridExamConsole(exam);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(NewlecAppConfig.class);
		
		ExamConsole console = (ExamConsole) context.getBean(InlineExamConsole.class);
		console.print();
		
	}

}
