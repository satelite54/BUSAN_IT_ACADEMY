<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>혻
<%
	Connection conn = null;	

	try {
		String url = "jdbc:mysql://localhost:3306/WebMarketDB";
		String user = "root";
		String password = "rhkdwo9079@";

		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		
	} catch (SQLException ex) {
		out.println("?곗씠?곕쿋?댁뒪 ?곌껐???ㅽ뙣?섏뿀?듬땲??<br>");
		out.println("SQLException: " + ex.getMessage());
	}
		
%>
