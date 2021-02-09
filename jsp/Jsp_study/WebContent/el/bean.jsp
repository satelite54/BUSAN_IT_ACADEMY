<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<jsp:useBean id="bean" class="el.ELBean"></jsp:useBean>
<jsp:setProperty property = "siteName" name = "bean"/>
사이트명 : <jsp:getProperty property="siteName" name="bean"/>
사이트명 : <%=bean.getSiteName()%>
사이트명 : ${bean.siteName}<br>