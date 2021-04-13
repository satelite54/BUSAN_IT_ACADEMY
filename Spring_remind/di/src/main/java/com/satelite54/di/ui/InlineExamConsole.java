package com.satelite54.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.satelite54.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {
	
	// 1. �ʵ� Autowired�� �⺻ �����ڰ� �־����.
	
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
	// 1. ù��°�� �ش� ���¸� ������ �� �ִ� �ڷ����� ���� ���� ã�� ����
	// 2. �ι�°�� ������ ���� id�� �������� ���� ���� ã�� ����
	// 3. �������� Qualifier�� �̿�
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
