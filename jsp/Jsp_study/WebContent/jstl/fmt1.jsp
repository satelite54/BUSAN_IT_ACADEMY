<%@ page contentType="text/html; charset=EUC-KR"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value ="EUC-KR"/>
<!-- Locale 지정 ko 국가 코드는 kr -->
<fmt:setLocale value="ko_kr"/>
name : ${param.name}
<form method="post">
	name : <input name ="name" value="홍길동">
	<input type="submit">
</form>