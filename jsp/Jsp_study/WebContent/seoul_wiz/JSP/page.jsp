<%@ page contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "java.util.Arrays" %>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<html>
	<head>
	</head>
	<body>
		<%
			int[] iArr = {30, 20, 10};
			Arrays.sort(iArr);
			out.println(Arrays.toString(iArr));
		%>
		
	
	</body>
</html>

