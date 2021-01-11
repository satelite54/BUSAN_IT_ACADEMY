<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- forward 액션태그를 통해 페이지를 이동하면서 param 태그로 데이터를 넘겨준다. -->
	<jsp:forward page="forward_param.jsp">
		<jsp:param value="abcdef" name="id"/>
		<jsp:param value="1234" name="pw"/>
	</jsp:forward>
</body>
</html>