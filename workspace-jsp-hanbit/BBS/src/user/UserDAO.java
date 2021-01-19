package user;

import java.sql.*;

public class UserDAO {
	//DB연결 객체들 선언
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() { //생성자 생성시 DB연결 conn
		try {
			String url = "jdbc:mysql://localhost:3306/BBS?useSSL=false";
			String user = "root";
			String password = "1234";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword from USER where userID = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1; //로그인 성공
				}
				else{
					return 0; //비밀번호 불일치
				}
			}
			return -1; //아이디 없음
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(); //DB닫기
		}
		return -2; //DB 오류
	}
	
	public int join(User user) {
		String SQL = "INSERT INTO user VALUES(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			return pstmt.executeUpdate();	//업데이트 결과가 양수(1)이면 정상
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();  //DB닫기
		}
		return -2; //DB 오류
	}
	
	private void closeAll() {
		try {
			if(rs != null)    rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null)  conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}









