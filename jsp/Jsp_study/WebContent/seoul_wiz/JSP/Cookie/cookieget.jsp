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
				String str = cookies[i].getName();
				if(str.equals("cookieN")) {
					out.println("cookies[" + i + "] name" + cookies[i].getName() + "<br/>");
					out.println("cookies[" + i + "] value" + cookies[i].getValue() + "<br/>");
					out.println("=============================================<br>");
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
		%>
		
		<a href="cookiedel.jsp">cookie delete</a>
	</body>
</html>

