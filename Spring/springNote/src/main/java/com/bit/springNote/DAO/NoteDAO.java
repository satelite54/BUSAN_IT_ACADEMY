package com.bit.springNote.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bit.springNote.DTO.NoteDTO;

public class NoteDAO {
	DataSource ds; //Connection을 관리하기 위한 객체
	public NoteDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	//writer
	public void write(String writer, String content) {
		Connection con = null;
		PreparedStatement pstmt = null; // 쿼리문을 객체화 시키는
		String sql = null;
		try {
			con = ds.getConnection();
			sql = "insert into tblNote(id, writer, content)values(tblNoteSeq.nextval,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, content);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!= null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//list
	public List<NoteDTO> getNoteList() {
		Connection con = null;
		PreparedStatement pstmt = null; // 쿼리문을 객체화 시키는
		ResultSet rs = null;
		String sql = null;
		List<NoteDTO> dtos = new ArrayList<NoteDTO>();
		try {
			con = ds.getConnection();
			sql = "select * from tblNote order by id desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String writer = rs.getString(2);
				String content = rs.getString(3);
				NoteDTO dto = new NoteDTO(id, writer, content);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!= null) con.close();
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	//delete
	public void delete(int id) {
		Connection con = null;
		PreparedStatement pstmt = null; // 쿼리문을 객체화 시키는
		ResultSet rs = null;
		String sql = null;
		List<NoteDTO> dtos = new ArrayList<NoteDTO>();
		try {
			con = ds.getConnection();
			sql = "delete from tblNote where id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!= null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
