package mail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberMgr {

	private DBConnectionMgr pool;

	public MemberMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	// id�� email�� ���� : pwd ����
	// select pwd from tblMember id=? and email=?
	public String findPwd(String id, String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String pwd = null;
		try {
			con = pool.getConnection();
			sql = "select pwd from tblMember where id=? and email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			if (rs.next())
				pwd = rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return pwd;
	}

	public void sendIdPwd() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "select id, password, mail from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String pwd = rs.getString(2);
				String email = rs.getString(3);
				// System.out.println(id + " : " + pwd + " : " + email);
				String title = "000.com에서 id와 pwd를 보냅니다.";
				String content = id + "/" + pwd;
				GmailSend.send(title, content, email);
			}
			System.out.println("성공~~~~~~~~~");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return;
	}

	public static void main(String[] args) {
		MemberMgr mgr = new MemberMgr();
		mgr.sendIdPwd();
	}
}
