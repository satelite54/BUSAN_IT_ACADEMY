<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
	String id = request.getParameter("id");
	String pwd= request.getParameter("pwd");
%>
id1 :<%=id %><br>
pwd1 : <%=pwd %><br>