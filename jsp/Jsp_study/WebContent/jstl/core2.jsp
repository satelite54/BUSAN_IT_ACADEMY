<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("EUC-KR"); //post��� �ѱ� ó��
	//get ��� �ѱ� ó�� -> server.xml(63���� ����) URIEncoding="EUC-KR"
%>
<c:if test="${param.id!=null}">
	<b>${param.id}</b>
</c:if>
<c:if test="${param.id==null}">
	<b>Guest</b>
</c:if>

<c:choose>
	<c:when test="${param.color=='yellow'}">
		<c:set var="c" value="�����"/>
	</c:when>
	<c:when test="${param.color=='blue'}">
		<c:set var="c" value="�Ķ���"/>
	</c:when>
	<c:when test="${param.color=='Red'}">
		<c:set var="c" value="������"/>
	</c:when>
	<c:when test="${param.color=='orange'}">
		<c:set var="c" value="��������"/>
	</c:when>
	<c:when test="${param.color=='pink'}">
		<c:set var="c" value="��ũ��"/>
	</c:when>
</c:choose>
���� �����ϴ� ���� <font color="${param.color}">${c}</font><br>
msg : ${param.msg}