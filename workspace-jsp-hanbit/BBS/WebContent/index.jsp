<%@ page import="user.UserDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    <<jsp:useBean id="user" class="user.User" scope="page"></jsp:useBean>
    <!--  form으로 부터 전달된 파라메터들을 User객체의 set메소드를 사용하여 저장 -->
    <<jsp:setProperty property="userID" name="user"/>
    <<jsp:setProperty property="userPassword" name="user"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>