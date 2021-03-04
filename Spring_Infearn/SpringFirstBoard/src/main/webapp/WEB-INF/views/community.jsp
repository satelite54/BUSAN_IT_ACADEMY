<%@page import="java.awt.dnd.DropTargetListener"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>JASET VAPE</title>


</head>
<body>
<script type="text/javascript"></script>
	<div class="container">
		<table class="table border-dark rounded">
			<thead class="thead-dark">
				<tr>
					<th scope="col">번호</th>
					<th scope="col">글 제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody class="border">
				<c:forEach var="bbs" items="${BoardList}" begin="${requestScope.page.blockStartNum}" end="${requestScope.page.blockLastNum}">
					<tr>
						<td>${bbs.BNum}</td>
						<td>${bbs.BTitle}</td>
						<td>${bbs.id}</td>
						<td>${bbs.BDate}</td>
						<td>${bbs.views}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav aria-label="Page navigation example">
			<ul class="pagination" style="justify-content: center;">
				<li class="page-item">
					<a class="page-link" href="communityListAction.do?page=${param.page - 1}" aria-label="Previous">
						<span aria-hidden="true"> &laquo;</span>
					</a>
				</li>
				<c:forEach var="Page" begin="1" end="${requestScope.page.lastPageNum}" varStatus="vs">
					<li class="page-item">
						<a class="page-link" href="communityListAction.do?page=${vs.count}">${vs.count}</a>
					</li>
				</c:forEach>
				<li class="page-item">
					<a class="page-link" href="communityListAction.do?page=${param.page + 1}"aria-label="Next">
						<span aria-hidden="true"> &raquo; </span>
					</a>
				</li>
			</ul>
		</nav>
		<a href="#" onclick="checkForm1(); return false;"
			class="btn btn-success float-right">글쓰기</a>
	</div>
	<script
		type="text/javascript">function checkForm1() {if (${id==null}) {alert("로그인 해주세요.");return false;}location.href = "communityWrite.do?id=${id}"}</script>
	<script src="css/bootstrap.min.css"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>