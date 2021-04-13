package com.satelite54.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.satelite54.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {
	
	// 1. 필드 Autowired는 기본 생성자가 있어야함.
	
	@Autowired
//	@Qualifier(value = "exam2")
	private Exam exam;
	
	public InlineExamConsole() {
		System.out.println("constructor");
	}
	
	public InlineExamConsole(Exam exam) {
		System.out.println("overloaded constructor");
	}
	
	public Exam getExam() {
		return exam;
	}
	// 1. 첫번째로 해당 형태를 참조할 수 있는 자료형을 가진 빈을 찾아 주입
	// 2. 두번째로 스프링 빈의 id와 변수명이 같은 빈을 찾아 주입
	// 3. 세번쨰로 Qualifier를 이용
//	@Autowired
//	@Qualifier(value = "exam1")
//	public void setExam(Exam exam) {
//		System.out.println("setter");
//		this.exam = exam;
//	}
	
	public void print() {
		System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());	
	}
}
