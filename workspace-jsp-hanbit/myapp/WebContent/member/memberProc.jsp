<%@page contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="mgr" class="member.MemberMgr"/>
<jsp:useBean id="bean" class="member.MemberBean"/>
<jsp:setProperty property="*" name="bean"/>
<%
		boolean result = mgr.insertMember(bean);
		String msg = "���� ����";
		String url = "member.jsp";
		if(result){
			msg = "���� ����";
			url = "login.jsp";
			//session.setAttribute("idKey", bean.getId());
		}
%>
<script>
	alert("<%=msg%>");
	location.href = "<%=url%>";
</script>







