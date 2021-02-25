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
	<table border="1" width="500">
		<tr>
			<td>��ȣ</td>
			<td>�̸�</td>
			<td>����</td>
			<td>��¥</td>
			<td>��ȸ��</td>
		</tr>
				
		<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.id}</td>
			<td>${dto.name}</td>
			<td><a href="contentView?id=${dto.id}">${dto.title}</a></td>
			<td>${dto.regdate}</td>
			<td>${dto.hit}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="writeView">���ۼ�</a>
		</tr>
	</table>
</body>
</html>