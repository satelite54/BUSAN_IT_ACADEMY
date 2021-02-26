package com.student.member;

import org.springframework.context.annotation.Configuration;

@Configuration //이건 스프링 컨테이너 설정파일이야
public class MemberConfig {
	//<bean id="student" class="com.student.StudentDao>
	public StudentDao studentDao() {
		return new StudentDao();
	}
}
