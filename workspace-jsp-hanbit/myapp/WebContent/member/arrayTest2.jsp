<!-- arrayTest2.jsp -->
<%@page contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		//form���� �ΰ� �̻��� ������ name���� ��û�Ǵ� ���� �ڵ� �迭ó��
		String hobby[] = request.getParameterValues("hobby");
		for(int i =0;i<hobby.length;i++){
			out.print(hobby[i]+"<br/>");
		}	
%>
<jsp:useBean id="bean" class="member.MemberBean"/>
<jsp:setProperty property="*" name="bean"/>
<!--  bean.setHobby(request.getParameterValues("hobby"));  -->











