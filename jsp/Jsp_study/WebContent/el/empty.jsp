<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
	String id = request.getParameter("id");
	if(id==null) {
		
	} else {
		
	}
%>
id의 요청 여부 : ${empty param.id}<br>
<a href="empty.jsp?id=aaa">id 값 요청</a> ||
<a href="empty.jsp">id 요청 값이 없을 때</a>