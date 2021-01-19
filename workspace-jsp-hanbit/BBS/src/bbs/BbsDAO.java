package bbs;

import java.sql.*;
import java.util.ArrayList;

public class BbsDAO {
	//DB연결 객체들 선언
	private Connection conn;
	private ResultSet rs;
	
	public BbsDAO() { //생성자 생성시 DB연결 conn
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
	
	public void closeAll() {
		try {
			if(rs != null)    rs.close();
			if(conn != null)  conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	// 현재 날짜를 DB에서 검색해 리턴 => 글쓰기 할때 입력할 날짜
	public String getDate() {
		String SQL = "SELECT now()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1); //현재 날짜와 시간을 리턴
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ""; //DB오류
	}
	//가장 최근에 적은 글의 id + 1을 리턴 => 글쓰기 번호를 자동 생성
	public int getNext() {
		//bbsID로 정렬(거꾸로) 가장 위에 있는 번호+1을 리턴
		String SQL = "SELECT bbsID from BBS order by bbsID desc";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) { //제일 첫줄
				return rs.getInt(1) + 1; //번호 + 1
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //DB오류
	}
	//새 게시판 글을 DB에 입력한다.
	public int write(String bbsTitle, String userID, String bbsContent) {
		int next = getNext(); //다음 글번호
		String now = getDate(); //현재 날짜 시간
		
		String SQL = "INSERT INTO BBS values(?,?,?,?,?,?)"; //물음표 6개
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, next);		    //글번호
			pstmt.setString(2, bbsTitle);	//제목
			pstmt.setString(3, userID);		//글쓴아이디
			pstmt.setString(4, now);		//날짜
			pstmt.setString(5, bbsContent);	//내용
			pstmt.setInt(6, 1);		        //1:보여줌 0:삭제(안보임) 
			return pstmt.executeUpdate();   //업데이트 후 정상일때 1리턴				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //DB오류
	}
	// 한화면 게시글 10개를 보여준다. => 최대 10개의 bbs객체 리스트를 리턴하는 메소드
	public ArrayList<Bbs> getList(int pageNumber){
		String SQL = "select * from BBS where bbsID < ? and bbsAvailable = 1 order by bbsID desc limit 10";
		ArrayList<Bbs> list = new ArrayList<Bbs>(); //bbs 객체를 입력하기 위한 리스트
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext()-(pageNumber-1)*10 );
			rs = pstmt.executeQuery();   //결과 리턴	
			while(rs.next()) {
				Bbs bbs = new Bbs(); //bbs 빈 객체 생성
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				list.add(bbs);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//다음 페이지가 있는가? ( 페이지넘버에 해당하는 게시물이 있는가?)
	public boolean nextPage(int pageNumber) {
		String SQL = "select * from BBS where bbsID < ? and bbsAvailable = 1";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext()-(pageNumber-1)*10 );
			rs = pstmt.executeQuery();   
			if(rs.next()) {
				return true;  //결과가 있으면 true
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;        //결과가 없으면 false
	}
	//글번호를 입력해서 데이터를 DB에서 리턴
	public Bbs getBbs(int bbsID) {
		String SQL = "select * from BBS where bbsID = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID );
			rs = pstmt.executeQuery();   
			if(rs.next()) {
				Bbs bbs = new Bbs(); //빈 bbs객체를 생성
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				return bbs;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; //에러
	}
	//id의 게시글을 업데이트 하기
	public int update(int bbsID, String bbsTitle, String bbsContent) {
		String SQL = "update BBS set bbsTitle=?, bbsContent=? where bbsID = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, bbsTitle );
			pstmt.setString(2, bbsContent );
			pstmt.setInt(3, bbsID );
			return pstmt.executeUpdate();  //정상적으로 업데이트시 1이 리턴
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //DB 에러
	}
	//게시글을 DB에서 삭제
	public int delete(int bbsID) {
		String SQL = "update BBS set bbsAvailable=0 where bbsID = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID );
			return pstmt.executeUpdate();  //정상적으로 업데이트시 1이 리턴
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //DB 에러
	}
	
	
	
	
	
	
}









