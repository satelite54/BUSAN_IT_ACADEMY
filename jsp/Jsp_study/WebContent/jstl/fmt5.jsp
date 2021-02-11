<%@ page contentType="text/html; charset=EUC-KR"%>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("EUC-KR");%>
<fmt:setBundle var="note" basename ="jstl.note"/>
county : <fmt:message bundle="${note}" key="country"/><br>
siteName : <fmt:message bundle="${note}" key="siteName"/><br>
msg : <fmt:message bundle="${note}" key="msg">
			<fmt:param value="${param.msg}"/>	
		</fmt:message><p>
<a href="fmt5.jsp?msg=¹Ý°©´Ù.">fmt5.jsp</a>