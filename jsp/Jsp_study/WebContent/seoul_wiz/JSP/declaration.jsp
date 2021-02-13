<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<html>
	<head>
	</head>
	<body>
		<%!
			int i = 10;
			String str = "ABCDE";
			
			public int sum(int a, int b) {
				return a + b;
			}
		%>
		
		<%
			out.println(i);
			out.println(str);
			out.println(sum(10, 10));
		%>
	</body>
</html>

