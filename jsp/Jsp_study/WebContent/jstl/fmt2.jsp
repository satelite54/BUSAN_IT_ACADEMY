<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="now" value="<%=new Date()%>"/>
<h3>Korea</h3>
<fmt:setLocale value="ko_kr"/>
�ݾ� : <fmt:formatNumber value="500000000" type ="currency"/><br>
�ݾ� : <fmt:formatDate value="${now}" type ="both" dateStyle="full" timeStyle="full"/><br>
<h3>Japan</h3>
<fmt:setLocale value="ja_jp"/>
�ݾ� : <fmt:formatNumber value="500000000" type ="currency"/><br>
�ݾ� : <fmt:formatDate value="${now}" type ="both" dateStyle="full" timeStyle="full"/><br>
<h3>USA</h3>
<fmt:setLocale value="en_us"/>
�ݾ� : <fmt:formatNumber value="500000000" type ="currency"/><br>
�ݾ� : <fmt:formatDate value="${now}" type ="both" dateStyle="full" timeStyle="full"/><br>