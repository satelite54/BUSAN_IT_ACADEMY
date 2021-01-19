<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	  <div class="card">
	  	<div class="card-header">
	  		글쓰기 양식
	  	</div>
	  	<div class="card-body">
	  		<form action="writeAction.jsp" method="post">
	  			<input type="text" class="form-control mb-3" name="bbsTitle" placeholder="글제목" maxlength="50" required>
	  			<textarea class="form-control mb-3" name="bbsContent" style="height: 350px" placeholder="글내용" maxlength="2048" required></textarea>
	  			<div class="row">
					<input type="submit" value="글쓰기" class="btn btn-primary ml-auto mr-3">
				</div>
	  		</form>
	  	</div>
		
	  </div>
	</div>





       <!-- 부트스트랩 JS (1.제이쿼리, 2.번들) -->
  <script src="js/jquery-3.5.1.min.js"></script>
  <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>