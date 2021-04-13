package com.satelite54.di.ui;

import com.satelite54.di.entity.Exam;

public class GridExamConsole implements ExamConsole{
	private Exam exam;

	public GridExamConsole(Exam exam) {
		this.exam = exam;
	}
	
	public Exam getExam() {
		return exam;
	}



	public void setExam(Exam exam) {
		this.exam = exam;
	}



	public void print() {
		System.out.println(exam.total());
		System.out.println(exam.avg());
	}
}
