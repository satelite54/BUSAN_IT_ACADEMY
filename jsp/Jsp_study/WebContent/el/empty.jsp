<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
	String id = request.getParameter("id");
	if(id==null) {
		
	} else {
		
	}
%>
id�� ��û ���� : ${empty param.id}<br>
<a href="empty.jsp?id=aaa">id �� ��û</a> ||
<a href="empty.jsp">id ��û ���� ���� ��</a>