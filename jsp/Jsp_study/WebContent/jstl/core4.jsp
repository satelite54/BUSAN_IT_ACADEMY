<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <c:import url="http://localhost/myapp/jstl/core2.jsp">
	<c:param name="id" value="aaa"/>
	<c:param name="color" value="blue"/>
	<c:param name="msg" value="¿À´ÃÀº Áñ°Å¿î ¿¬ÈÞ Àü³¯~"/>
</c:import> --%>
<hr>
<c:url var="url1" value="https://www.google.com/">
	<c:param name="q" value="jspstudy"/>
	<c:param name="safe" value="off"/>
</c:url>
<a href="${url1}">±¸±Û¿¡¼­ jspstudy °Ë»ö</a>