<%@ page contentType="text/html; charset=EUC-KR"
		 isELIgnored="false"%><!-- EL ������ ������ ���ΰ� �� ������ �� �ΰ�.-->
<%
	request.setCharacterEncoding("EUC-KR");
	// ����� : page < request < session < application
	
	request.setAttribute("siteName", "JSPStudy.co.kr");
%>
����Ʈ�� : <%=request.getAttribute("siteName")%><br>
����Ʈ�� : ${siteName}