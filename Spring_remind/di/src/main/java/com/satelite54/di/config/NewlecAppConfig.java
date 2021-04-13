package com.satelite54.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.satelite54.di.entity.Exam;
import com.satelite54.di.entity.NewlecExam;

//설정을 위한 어노테이션이다.
@Configuration
@ComponentScan(value = "com.satelite54.di.entitiy")
public class NewlecAppConfig {
	
	//IOC 컨테이너에 담아줌
	@Bean
	public Exam exam() { //컨테이너에 담을때 exam이 id가 된다.
		return new NewlecExam();
	}
}
