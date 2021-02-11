<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="dayTime" value="<%=new Date()%>"/>
<h3>Korea</h3>
날짜 : <fmt:formatDate value="${dayTime}" type ="date" dateStyle="full"/><br>
시간 : <fmt:formatDate value="${dayTime}" type ="time"/><br>

<h3>London</h3>
<fmt:setTimeZone value="Europe/London"/>
날짜 : <fmt:formatDate value="${dayTime}" type ="date" dateStyle="full"/><br>
시간 : <fmt:formatDate value="${dayTime}" type ="time"/><br>