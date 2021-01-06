<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag</title>
</head>
<body>
	<!--  선언 -->
	<%! int data = 50; %>
	<%
	//out은 화면출력을 위한 스트림
		/* 일반 자바코트를 입력 */
		out.println("Value of the variable is:" + data);
	%>
</body>
</html>
