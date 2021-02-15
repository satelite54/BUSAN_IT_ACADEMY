<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<html>
	<head>
	</head>
	<body>
		<%
			Cookie[] cookies = request.getCookies();
			for(int i = 0; i < cookies.length; i++) {
				out.println(cookies[i].getName());
				out.println(cookies[i].getValue());
			}
		%>
	</body>
</html>

