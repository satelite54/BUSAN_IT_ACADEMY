<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bbs.Bbs" %>    
<%@ page import="bbs.BbsDAO" %>    
<%@ page import="java.util.ArrayList" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시판 웹사이트</title>
  <!-- 부트스트랩 CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<% 
	//세션에 userID를 얻어와서 현재 로그인 상태인지 확인한다.
	String userID = null;
	if(session.getAttribute("userID") != null){ 
		//널값이 아니라면 아이디를 가져온다.
		userID = (String)session.getAttribute("userID");
	}
%>
<nav class="navbar navbar-expand-md navbar-light bg-light">
  <a class="navbar-brand" href="main.jsp">JSP 게시판</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <!-- collapse 안에 있는 내용은 햄버거 버튼이 나오면 사라진다. -->
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav nav-tabs">
      <li class="nav-item">
        <a class="nav-link" href="main.jsp">메인</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="bbs.jsp">게시판</a>
      </li>
    </ul>
    <%
    	//로그인 안된상태
    	if(userID == null) {
    %>
    <ul class="navbar-nav ml-auto">
     <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="Dropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          	접속하기
        </a>
        <div class="dropdown-menu" aria-labelledby="Dropdown">
          <a class="dropdown-item" href="login.jsp">로그인</a>
          <a class="dropdown-item" href="join.jsp">회원가입</a>         
        </div>
      </li>
    </ul>
    <%
    	} else { //로그인 된상태
    %>
     <ul class="navbar-nav ml-auto">
     <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="Dropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          	회원관리
        </a>
        <div class="dropdown-menu" aria-labelledby="Dropdown">
          <a class="dropdown-item" href="logoutAction.jsp">로그아웃</a>       
        </div>
      </li>
    </ul>   
    <%
    	}
    %>
  </div>
</nav>
	<div class="container mt-3">
	  <div class="row">
		<table class="table table-hover text-center" style="border: 1px solid #ddd">
		  <thead class="thead-light">
		    <tr>
		      <th>번호</th>
		      <th>제목</th>
		      <th>작성자</th>
		      <th>작성일</th>
		    </tr>
		  </thead>
		  <tbody>
		  <%
		  	int pageNumber = 1;
		  	if(request.getParameter("pageNumber") != null) {
		  		//널값이 아니라면 페이지 넘버를 가져온다.
		  		pageNumber = Integer.parseInt((String) request.getParameter("pageNumber"));
		  	}
		  	BbsDAO dao = new BbsDAO();
		  	ArrayList<Bbs> list = dao.getList(pageNumber);

		  	for (int i = 0; i < list.size(); i++) {
		  %>
		    <tr>
		      <td><%=list.get(i).getBbsID()%></td>
		      <td><a href="view.jsp?bbsID=<%=list.get(i).getBbsID()%>"><%=list.get(i).getBbsTitle()%></a></td>
		      <td><%=list.get(i).getUserID()%></td>
		      <td><%=list.get(i).getBbsDate().substring(0,19)%></td>
		    </tr>
	     <%
	  	  }
	     %>
		  </tbody>
		</table>
	  </div>
	  <div class="row">
	  <%
	  	if(pageNumber > 1){
	  %>
	  	<a href="bbs.jsp?pageNumber=<%=pageNumber-1%>" class="btn btn-success mr-3">이전</a>
	  <%
	  	} if(dao.nextPage(pageNumber+1)) {
	  %>
	  	<a href="bbs.jsp?pageNumber=<%=pageNumber+1%>" class="btn btn-success">다음</a>
	  <%
	  	}
	  	dao.closeAll(); //db 닫기
	  %>	  
		<a href="write.jsp" class="btn btn-primary ml-auto px-md-5">글쓰기</a>
	  </div>
	</div>





       <!-- 부트스트랩 JS (1.제이쿼리, 2.번들) -->
  <script src="js/jquery-3.5.1.min.js"></script>
  <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>