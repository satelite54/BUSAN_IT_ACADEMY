<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
	//jsp 문법에는 page 영역이 pageContext
	pageContext.setAttribute("msg", "오늘은 즐거운 화요일");
	session.setAttribute("id", "simba222");
	session.setMaxInactiveInterval(1 * 60);
	application.setAttribute("id", "simba222");
%>
id ${sessionScope.id}<br>
siteMane ${applictionScope.steNme}<br>
session.Id : <%=session.getId()%>