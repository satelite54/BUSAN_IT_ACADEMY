    <!-- 지시자는 JSP페이지의 전체적의 속성을 지정할 때 사용 합니다.
    	page, include, taglib 가 있으며, <%@ 속성 %> 형태로 사용
     -->
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int[] nAry = {10, 20, 30};
		out.println(Arrays.toString(nAry));
	%>
</body>
</html>