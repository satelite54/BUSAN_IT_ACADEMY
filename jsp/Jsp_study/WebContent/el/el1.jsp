<%@ page contentType="text/html; charset=EUC-KR"
		 isELIgnored="false"%><!-- EL 문법을 무시할 것인가 안 무시할 것 인가.-->
<%
	request.setCharacterEncoding("EUC-KR");
	// 저장소 : page < request < session < application
	
	request.setAttribute("siteName", "JSPStudy.co.kr");
%>
사이트명 : <%=request.getAttribute("siteName")%><br>
사이트명 : ${siteName}