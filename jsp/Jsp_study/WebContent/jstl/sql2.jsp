<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<sql:update dataSource="${db}">
	update member set name=? where id=?
	<sql:param value ="${'ȫ���'}"/>
	<sql:param value ="${'bbb'}"/>
</sql:update>
������Ʈ �Ͽ����ϴ�.<br>
<a href="sql1.jsp">SELECT</a>