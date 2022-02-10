package com.lnh.semi.report.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.lnh.semi.report.dto.ReportDTO;

/**DB와 관련된 접속, 쿼리실행 메서드들 보유**/
public class ReportDAO {

	private DBConnection2 pool = null;
	private static ReportDAO instance = null;
	
	private ReportDAO() {
		pool = DBConnection2.getInstance();
	}
	
	public static ReportDAO getInstance() {
		if(instance==null) {
			instance = new ReportDAO();
		}
		
		return instance;
	}
	
	/*글 목록 가져오기*/
	public ArrayList<ReportDTO> getList(int page){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<ReportDTO> list = new ArrayList<ReportDTO>();
		
		try {
			con = pool.getConnection();
//			sql = "select code, title, rdate, hit from report order by boardGroup desc, boardSequence asc";
			sql = "select * from ( select r.*, rownum num from (select code, title, rdate, hit from report order by boardGroup desc, boardSequence) r) where num between ? and ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, (page-1)*10+1);
			pstmt.setInt(2, page*10);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReportDTO dto = new ReportDTO();
				dto.setCode(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setRdate(rs.getDate(3));
				dto.setHit(rs.getInt(4));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt, rs);
		}
		return list;
	}
	
	/*글 작성*/
	public boolean insertW(ReportDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		
		try {
			con = pool.getConnection();
			sql = "insert into report values (seq_report.nextval,?,?,?,?,0,sysdate,seq_report.currval,0,0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			
			int r = pstmt.executeUpdate();
			
			if(r>0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt);
		}
		return flag;	//true 글쓰기 성공, false 실패
	}
	
	/*게시글 디테일 읽기*/
	public ReportDTO readW(int code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ReportDTO dto = new ReportDTO();
		
		try{
			con = pool.getConnection();
			sql = "update report set hit=hit+1 where code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.executeUpdate();
			
			pstmt = null;
			sql = "select * from report where code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			rs.next();
			
			dto.setCode(rs.getInt(1));
			dto.setId(rs.getString(2));
			dto.setPassword(rs.getString(3));
			dto.setTitle(rs.getString(4));
			dto.setContent(rs.getString(5));
			dto.setHit(rs.getInt(6));
			dto.setRdate(rs.getDate(7));
			dto.setBoardGroup(rs.getInt(8));
			dto.setBoardSequence(rs.getInt(9));
			dto.setBoardLevel(rs.getInt(10));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt, rs);
		}
		return dto;
	}
	
	/*게시글 하나 가져오기*/
	public ReportDTO getW(int code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ReportDTO dto = new ReportDTO();
		
		try{
			con = pool.getConnection();
			sql = "select * from report where code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			rs.next();
			
			dto.setCode(rs.getInt(1));
			dto.setId(rs.getString(2));
			dto.setPassword(rs.getString(3));
			dto.setTitle(rs.getString(4));
			dto.setContent(rs.getString(5));
			dto.setHit(rs.getInt(6));
			dto.setRdate(rs.getDate(7));
			dto.setBoardGroup(rs.getInt(8));
			dto.setBoardSequence(rs.getInt(9));
			dto.setBoardLevel(rs.getInt(10));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt, rs);
		}
		return dto;
	}
	
	/*글번호 가져와서 글 내용 업데이트*/
	public boolean updateW(ReportDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		
		try {
			con = pool.getConnection();
			
			sql = "update report set title=?, content=?, rdate=sysdate, password=? where code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getPassword());
			pstmt.setInt(4, dto.getCode());
			int r = pstmt.executeUpdate();
			
			if(r>0) {
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt);
		}
		return flag;	//true 업데이트 성공, false 실패
	}
	
	/*글번호 가져와서 글 삭제*/
	public boolean deleteW(int code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		
		try {
			con = pool.getConnection();
			
			sql = "delete from report where code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			int r = pstmt.executeUpdate();
			
			if(r>0) {
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt);
		}
		return flag;	//true 삭제 성공, false 실패
	}
	
	/*제목 검색 리스트 가져오기*/
	public ArrayList<ReportDTO> searchList(String searchWord, int page){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<ReportDTO> searchList = new ArrayList<ReportDTO>();
		
		try {
			con = pool.getConnection();
			sql = "select * from ( select r.*, rownum num from (select code, title, rdate, hit from report where title like '%'||?||'%' order by boardGroup desc, boardSequence) r) where num between ? and ?"; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchWord);
			pstmt.setInt(2, (page-1)*10+1);
			pstmt.setInt(3, page*10);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReportDTO dto = new ReportDTO();
				dto.setCode(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setRdate(rs.getDate(3));
				dto.setHit(rs.getInt(4));
				
				searchList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt, rs);
		}
		
		return searchList;
	}
	
	/*답글 작성*/
	public boolean insertReply(ReportDTO childDTO, ReportDTO parentDTO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		
		try {
			con = pool.getConnection();
			sql = "insert into report values (seq_report.nextval,?,?,?,?,0,sysdate,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, childDTO.getId());
			pstmt.setString(2, parentDTO.getPassword());
			pstmt.setString(3, childDTO.getTitle());
			pstmt.setString(4, childDTO.getContent());
			pstmt.setInt(5, parentDTO.getBoardGroup());
			pstmt.setInt(6, parentDTO.getBoardSequence()+1);
			pstmt.setInt(7, parentDTO.getBoardLevel()+1);
			
			int r = pstmt.executeUpdate();
			
			if(r>0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt);
		}
		return flag;	//true 글쓰기 성공, false 실패
	}
	
	public boolean replyUpdate(ReportDTO parentDTO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		
		try {
			con = pool.getConnection();
			sql = "update report set boardSequence=boardSequence+1 where boardGroup=? and boardSequence>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, parentDTO.getBoardGroup());
			pstmt.setInt(2, parentDTO.getBoardSequence());
			int r = pstmt.executeUpdate();
			
			if(r>0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt);
		}
		return flag;
	}
	
	/*글 개수 카운트*/
	public int getListCount() {
		int count = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "select count(code) from report";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, stmt, rs);
		}
		return count;
	}
	
	public int getSearchListCount(String searchWord) {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "select count(code) from report where title like '%'||?||'%'"; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchWord);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt, rs);
		}
		
		return count;
	}
}
