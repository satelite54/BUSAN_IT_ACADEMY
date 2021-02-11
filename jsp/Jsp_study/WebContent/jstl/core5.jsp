<!-- core4.jsp  -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<c:import url="http://localhost/Jsp_study/jstl/core2.jsp">
	<c:param name="id" value="aaa"/>
	<c:param name="color" value="blue"/>
	<c:param name="msg" value="오늘은 즐거운 연휴 전날~"/>
</c:import>
<hr>
<c:url var="url1" value="http://www.google.com/">
	<c:param name="q" value="jspstudy"/>
	<c:param name="safe" value="off"/>
	
	



</c:url>
<a href="${url1}">구글에서 jspstudy검색</a>