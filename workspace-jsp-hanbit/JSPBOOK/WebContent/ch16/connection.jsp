<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>혻
<html>
<head>
<title>Database SQL</title>
</head>
<body>
	<%
		Connection conn = null;
		try {
			String url = "jdbc:mysql://localhost:3306/JSPBookDB";
			String user = "root";
			String password = "1234";

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			out.println("?곗씠?곕쿋?댁뒪 ?곌껐???깃났?섏뿀?듬땲??");
		} catch (SQLException ex) {
			out.println("?곗씠?곕쿋?댁뒪 ?곌껐???ㅽ뙣?섏뿀?듬땲??<br>");
			out.println("SQLException: " + ex.getMessage());
		} finally {
			if (conn != null)
				conn.close();
		}
	%>
</body>
</html>
