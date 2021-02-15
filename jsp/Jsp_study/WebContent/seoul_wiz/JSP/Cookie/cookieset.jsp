<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<html>
	<head>
	</head>
	<body>
		<%
			Cookie cookie = new Cookie("cookieN", "cookieV");
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);
		%>
		
		<a href="cookieget.jsp">cookie get</a>
		
	</body>
</html>

