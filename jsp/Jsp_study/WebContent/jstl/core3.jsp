<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("EUC-KR");
	String str1[] = {"Java", "JSP", "Spring", "Android"};
	String str2 = "Ʈ���̽�,AOA;����ũ,���座��";
%>
<c:set var="arr" value="<%=str1%>"/>
<c:forEach var="i" items="${arr}" begin="0" step="1" end="3">${i}<br>
</c:forEach>
<hr align="left" width="250">
<c:set var="s" value="<%=str2%>"/>
<c:forTokens var="st" items="${s}" delims=",;"><!-- ������ -->
	<b>${st}</b>&nbsp;
</c:forTokens>