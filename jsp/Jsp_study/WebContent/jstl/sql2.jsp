<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<sql:update dataSource="${db}">
	update member set name=? where id=?
	<sql:param value ="${'홍길순'}"/>
	<sql:param value ="${'bbb'}"/>
</sql:update>
업데이트 하였습니다.<br>
<a href="sql1.jsp">SELECT</a>