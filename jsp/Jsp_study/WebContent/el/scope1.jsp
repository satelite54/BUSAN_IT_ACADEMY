<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
	int sum = 0;
	for(int i = 1; i < 11; i++) {
		sum += i;
	}
	//auto boxing ;int -> Integer ��ȯ
	request.setAttribute("sum", sum);
%>
<!-- forward, include �׼��±��� Ư¡ : ��û����(request) ���� �Ѿ-->
<jsp:forward page="scope2.jsp"> 




</jsp:forward>