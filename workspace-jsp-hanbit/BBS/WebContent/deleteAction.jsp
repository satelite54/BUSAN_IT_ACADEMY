<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bbs.Bbs" %> 
<%@ page import="bbs.BbsDAO" %>  
<% request.setCharacterEncoding("UTF-8"); %> 


      
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
		} 
		int bbsID = 0; //글번호
		if(request.getParameter("bbsID") != null){ 
			//널값이 아니라면 글번호를 가져온다.
			bbsID = Integer.parseInt((String)request.getParameter("bbsID"));
		}
		if(bbsID == 0){
			out.println("<script>");
			out.println("alert('유효하지 않은 글입니다.')");
			out.println("location.href = 'bbs.jsp'");//게시판으로
			out.println("</script>");			
		}	
		
		BbsDAO dao = new BbsDAO();
		Bbs bbs = dao.getBbs(bbsID); //글번호의 전체글 객체를 가져와서		
		//현재 로그인된 id와 같은지 체크
		if(!userID.equals(bbs.getUserID())){ //같지 않다면
			out.println("<script>");
			out.println("alert('권한이 없습니다.')");
			out.println("location.href = 'bbs.jsp'");//게시판으로
			out.println("</script>");			
		} else { //로그인 되어 있으면서 글쓴이가 같을때

			//글번호의 게시글을 삭제한다. 이때 bbsAvailable을 0으로 한다.
			int result = dao.delete(bbsID);
			if(result == 1){ //정상(게시글 삭제완료)
				out.println("<script>");
				out.println("location.href = 'bbs.jsp'");//정상이므로 게시판으로
				out.println("</script>");
			} else { //오류 
				out.println("<script>");
				out.println("alert('글 삭제에 실패했습니다.')");
				out.println("history.back()"); //이전으로 돌아감
				out.println("</script>");			
			} 
	   }
		
	%>
</body>
</html>












