package com.student.member;

import org.springframework.context.annotation.Configuration;

@Configuration //�̰� ������ �����̳� ���������̾�
public class MemberConfig {
	//<bean id="student" class="com.student.StudentDao>
	public StudentDao studentDao() {
		return new StudentDao();
	}
}
