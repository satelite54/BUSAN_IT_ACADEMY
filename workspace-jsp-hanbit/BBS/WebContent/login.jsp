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
        <a class="nav-link" href="bbs.jsp">게시판</a>
      </li>
    </ul>
    <ul class="navbar-nav ml-auto">
     <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="Dropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          	접속하기
        </a>
        <div class="dropdown-menu" aria-labelledby="Dropdown">
          <a class="dropdown-item active" href="login.jsp">로그인</a>
          <a class="dropdown-item" href="join.jsp">회원가입</a>         
        </div>
      </li>
    </ul>
  </div>
</nav>
	<div class="container">
	  <div class="row">
	    <div class="col-lg-5 col-md-7 mx-auto">
	      <div class="bg-light p-5 mt-5">
	        <form action="loginAction.jsp" method="post">
	          <h3 class="text-center mb-3">로그인 화면</h3>
	          <input type="text" class="form-control mb-3" name="userID" placeholder="아이디" maxlength="20" required>
	          <input type="password" class="form-control mb-3" name="userPassword" placeholder="패스워드" maxlength="20" required>
	          <input type="submit" class="btn btn-primary form-control mb-3" value="로그인">         
	        </form>
	      </div>
	    </div>
	  </div>
	</div>





       <!-- 부트스트랩 JS (1.제이쿼리, 2.번들) -->
  <script src="js/jquery-3.5.1.min.js"></script>
  <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>