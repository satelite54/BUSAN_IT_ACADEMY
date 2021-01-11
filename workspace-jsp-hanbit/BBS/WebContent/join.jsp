<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시판 웹사이트</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="login.jsp">JSP 게시판</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav">
	      <li class="nav-item active">
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
		          <a class="dropdown-item" href="join.jsp">가입하기</a>
		        </div>
		      </li>
		 </ul>
	  </div>
	</nav>
	
		 	<div class="container">
	  <div class="row">
	    <div class="col-lg-5 col-md-7 mx-auto">
	      <div class="bg-light p-5 mt-5">
	        <form action="joinAction.jsp" method="post">
	          <h3 class="text-center mb-3">회원가입 화면</h3>	       
	          <input type="text" class="form-control mb-3" name="userID" placeholder="아이디" maxlength="20" required>
	          <input type="password" class="form-control mb-3" name="userPassword" placeholder="패스워드" maxlength="20" required>
	          <input type="text" class="form-control mb-3" placeholder="이름" name="userName" maxlength="20">
              <div class="text-center">
	            <div class="btn-group btn-group-toggle mb-3" data-toggle="buttons">
				  <label class="btn btn-success active">
				    <input type="radio" name="userGender" value="남성" autocomplete="off" checked> 남성
				  </label>
				  <label class="btn btn-success">
				    <input type="radio" name="userGender" value="여성" autocomplete="off"> 여성
				  </label>
				</div>
	          </div>
	          <input type="email" class="form-control mb-3" name="userEmail" placeholder="이메일" maxlength="50">
	          <input type="submit" class="btn btn-primary form-control mb-3" value="가입하기">     
	        </form>
	      </div>
	    </div>
	  </div>
	</div>
	
	<script src="css/bootstrap.min.css"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>