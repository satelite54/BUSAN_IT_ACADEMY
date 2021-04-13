package com.satelite54.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.satelite54.di.entity.Exam;
import com.satelite54.di.entity.NewlecExam;

//������ ���� ������̼��̴�.
@Configuration
@ComponentScan(value = "com.satelite54.di.entitiy")
public class NewlecAppConfig {
	
	//IOC �����̳ʿ� �����
	@Bean
	public Exam exam() { //�����̳ʿ� ������ exam�� id�� �ȴ�.
		return new NewlecExam();
	}
}
