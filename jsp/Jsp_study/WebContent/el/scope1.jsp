<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
	int sum = 0;
	for(int i = 1; i < 11; i++) {
		sum += i;
	}
	//auto boxing ;int -> Integer 변환
	request.setAttribute("sum", sum);
%>
<!-- forward, include 액션태그의 특징 : 요청정보(request) 같이 넘어감-->
<jsp:forward page="scope2.jsp"> 




</jsp:forward>