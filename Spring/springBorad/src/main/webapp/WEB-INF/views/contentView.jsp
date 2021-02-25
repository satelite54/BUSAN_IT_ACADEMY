<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>Spring board</h2>
	
	<table width="500" border="1">
		<tr>
			<td> 번호 </td>
			<td> <input name="name" size = "50" value = "${contentView.id}"> </td>
		</tr>
		<tr>
			<td> 히트 </td>
			<td> <input name="title" size = "50" value = "${contentView.hit}"> </td>
		</tr>
		<tr>
			<td> 이름 </td>
			<td> <input name="title" size = "50"  value = "${contentView.name}"> </td>
		</tr>
		<tr>
			<td> 제목 </td>
			<td> <input name="title" size = "50"  value = "${contentView.title}"> </td>
		</tr>
		<tr>
			<td> 내용 </td>
			<td> <textarea name="content" rows="10" >${contentView.content}</textarea> </td>
		</tr>
		<tr >
			<td colspan="3"> 
			<input type="submit" value="수정"> &nbsp;&nbsp; <a href="list">목록보기</a> <input type="submit" value="삭제"></td>
		</tr>
	</table>
	
</body>
</html>