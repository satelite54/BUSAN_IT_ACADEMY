<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bbs.BbsDAO" %>  

<% request.setCharacterEncoding("UTF-8"); %> 
<!-- Bbs클래스의 객체를 생성하여 이페이지에서 사용할수 있게한다. -->
<jsp:useBean id="bbs" class="bbs.Bbs" scope="page"/>
<!-- form으로부터 전달된 파라메터들을 bbs객체의 set메소드를 사용하여 저장 -->
<jsp:setProperty name="bbs" property="bbsTitle"/>
<jsp:setProperty name="bbs" property="bbsContent"/>
       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시판 웹사이트</title>
</head>
<body>
	<%  
		//세션에 userID를 얻어와서 현재 로그인 상태인지 확인한다.
		String userID = null;
		if(session.getAttribute("userID") != null){ 
			//널값이 아니라면 아이디를 가져온다.
			userID = (String)session.getAttribute("userID");
		}
		if(userID == null){ // 로그인이 안되어 있으면
			out.println("<script>");
			out.println("alert('로그인 하세요.')");
			out.println("location.href = 'login.jsp'");//로그인페이지로
			out.println("</script>");			
		} else { //로그인 되어 있으면
			//DB연결 메소드를 사용하기 위해 dao 객체 생성
			BbsDAO dao = new BbsDAO();
			//자바빈 객체 bbs에 저장된 title과 content를 입력
			int result = dao.write(bbs.getBbsTitle(), userID, bbs.getBbsContent());
			if(result == 1){ //정상(게시글 등록)
				out.println("<script>");
				out.println("location.href = 'bbs.jsp'");//정상이므로 게시판으로
				out.println("</script>");
			} else { //오류 
				out.println("<script>");
				out.println("alert('데이터베이스 오류입니다.')");
				out.println("history.back()"); //이전으로 돌아감
				out.println("</script>");			
			} 
	   }
		
	%>
</body>
</html>












