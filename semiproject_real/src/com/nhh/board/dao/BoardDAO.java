package com.nhh.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.nhh.board.dto.BoardDTO;

public class BoardDAO {

	private DBConnection pool;
	private static BoardDAO instance = null;
	
	private BoardDAO() {
		pool = DBConnection.getInstance();
	}
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	/*글 목록 가져오기*/
	public ArrayList<BoardDTO> getList(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			con = pool.getConnection();
			sql = "select no, title, writer, r_date, hit from board_tbl order by no desc";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setWriter(rs.getString(3));
				dto.setR_date(rs.getString(4));
				dto.setHit(rs.getInt(5));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, stmt, rs);
		}
		return list;
	}
	
	/*게시글 디테일 읽기*/
	public BoardDTO readW(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		BoardDTO dto = new BoardDTO();
		
		try{
			con = pool.getConnection();
			query = "update board_tbl set hit=hit+1 where no=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
			pstmt = null;
			query = "select * from board_tbl where no=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			rs.next();
			
			dto.setNo(rs.getInt(1));
			dto.setTitle(rs.getString(2));
			dto.setContent(rs.getString(3));
			dto.setWriter(rs.getString(4));
			dto.setR_date(rs.getString(5));
			dto.setHit(rs.getInt(6));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt, rs);
		}
		return dto;
	}
	
	/*게시글 하나 가져오기*/
	public BoardDTO getW(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		BoardDTO dto = new BoardDTO();
		
		try{
			con = pool.getConnection();
			query = "select * from board_tbl where no=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			rs.next();
			
			dto.setNo(rs.getInt(1));
			dto.setTitle(rs.getString(2));
			dto.setContent(rs.getString(3));
			dto.setWriter(rs.getString(4));
			dto.setR_date(rs.getString(5));
			dto.setHit(rs.getInt(6));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt, rs);
		}
		return dto;
	}
	
	/*글번호 가져와서 글 내용 업데이트*/
	public int updateW(BoardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = null;
		int r = 0;
		
		try {
			con = pool.getConnection();
			
			query = "update board_tbl set title=?, content=?, r_date=sysdate where no=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNo());
			r = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt);
		}
		return r;	//r=1이면 업데이트 성공, 0이면 실패
	}
	
	/*글번호 가져와서 글 삭제*/
	public int deleteW(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = null;
		int r = 0;
		
		try {
			con = pool.getConnection();
			
			query = "delete from board_tbl where no=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			r = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt);
		}
		return r;	//r=1이면 삭제 성공, 0이면 실패
	}
	
	/*글 작성*/
	public int insertW(BoardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = null;
		int r = 0;
		
		try {
			con = pool.getConnection();
			query = "insert into board_tbl (no,title,content,writer) values (board_seq.nextval,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getWriter());
			
			r = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt);
		}
		
		return r;	//r=1이면 글쓰기 성공, 0이면 실패
	}
	
	/*작성자 검색 리스트 가져오기*/
	public ArrayList<BoardDTO> searchList(String searchWord){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<BoardDTO> searchList = new ArrayList<BoardDTO>();
		
		try {
			con = pool.getConnection();
			String query = "select no, title, writer, r_date, hit from board_tbl where writer like '%'||?||'%' order by no desc";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setWriter(rs.getString(3));
				dto.setR_date(rs.getString(4));
				dto.setHit(rs.getInt(5));
				
				searchList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt, rs);
		}
		
		return searchList;
	}
}
