<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<jsp:useBean id="bean" class="el.ELBean"></jsp:useBean>
<jsp:setProperty property = "siteName" name = "bean"/>
����Ʈ�� : <jsp:getProperty property="siteName" name="bean"/>
����Ʈ�� : <%=bean.getSiteName()%>
����Ʈ�� : ${bean.siteName}<br>