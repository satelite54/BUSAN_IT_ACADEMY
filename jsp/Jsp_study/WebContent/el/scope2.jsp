<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
	//jsp �������� page ������ pageContext
	pageContext.setAttribute("msg", "������ ��ſ� ȭ����");
	session.setAttribute("id", "simba222");
	session.setMaxInactiveInterval(1 * 60);
	application.setAttribute("id", "simba222");
%>
id ${sessionScope.id}<br>
siteMane ${applictionScope.steNme}<br>
session.Id : <%=session.getId()%>