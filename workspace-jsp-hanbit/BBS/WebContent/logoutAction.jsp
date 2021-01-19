<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시판 웹사이트</title>
</head>
<body>
	<%
		session.invalidate(); //모든 세션을 삭제한다.	
	%>
	<script>
		location.href = 'main.jsp'; //메인 페이지로
	</script>
</body>
</html>