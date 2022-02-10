package com.mr81.Kakao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mr81.dbConnect.DBconnect;

public class KakaoDAO {

	public static KakaoDAO dao = null;

	private KakaoDAO() {
		// TODO Auto-generated constructor stub
	}

	public static KakaoDAO getInstance() {
		if (dao == null) {
			dao = new KakaoDAO();

		}
		return dao;
	}

	// 로그인 가능한 아이디 인지 확인 해보자

	public boolean login_Id(String id) {
		boolean login = false;
		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "";
		try {

			sql = "SELECT * FROM kakao WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				login = true;
			System.out.println("hi");
			} else {
			
				login = false;
				System.out.println("bye");
			}

		} catch (Exception e) {
			// TODO: handle exception 
			System.err.println("아이디 체크 오류"+e.getMessage());
		} finally {
			db.freeClose(conn, pstmt, rs);
		}

		return login;
	}
	public boolean regist_member(KakaoDTO dto) {
		boolean login = false;
		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();
		
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {

			sql = "INSERT  INTO kakao (id,tag,nick,pwd,yn) VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId()); 
			pstmt.setString(2, dto.getTag()); 
			pstmt.setString(3, dto.getNick()); 
			pstmt.setString(4, dto.getPwd());
			pstmt.setString(5, dto.getYn());
			int ret = pstmt.executeUpdate();
			if(ret>0) {
				login =true; 
				
			}else {
				login =false;
			}

		} catch (Exception e) {
			// TODO: handle exception
		
		System.err.println("삽입 오류: "+e.getMessage());
		} finally {
			db.freeClose(conn, pstmt);
		}

		return login;
	}


public String get_tag(String id) {
	String tag="" ; 
	
	DBconnect db = DBconnect.getInstance();
	Connection conn = db.get_Instance();
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	String sql = "";
	
	try {

		sql = "SELECT tag FROM kakao where id =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			tag=rs.getString("tag");
		}
	} catch (Exception e) {
		// TODO: handle exception
	
	System.err.println("삽입 오류: "+e.getMessage());
	} finally {
		db.freeClose(conn, pstmt,rs);
	}
	
	
	return tag;
}


}
