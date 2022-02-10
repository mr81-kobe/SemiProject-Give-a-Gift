package com.nhh.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.nhh.board.dto.CommentDTO;

public class CommentDAO {
	private DBConnection pool;
	private static CommentDAO instance = null;

	private CommentDAO() {
		pool = DBConnection.getInstance();
	}

	public static CommentDAO getInstance() {
		if (instance == null) {
			instance = new CommentDAO();
		}
		return instance;
	}

	/* comment 테이블의 idx로 데이터 한개 가져오기 */
	public CommentDTO getone(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		CommentDTO dto = new CommentDTO();

		try {
			con = pool.getConnection();
			sql = "select * from comment where idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();

			rs.next();
			dto.setIdx(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setPassword(rs.getString(3));
			dto.setContent(rs.getString(4));
			dto.setRdate(rs.getString(5));
			dto.setRef(rs.getInt(6));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt, rs);
		}
		return dto;
	}

	/* idx 데이터 수정 : update */
	public int update(CommentDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int r = 0;

		try {
			con = pool.getConnection();
			sql = "update comment_tbl set name=?, content=? where idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getIdx());
			r = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeClose(con, pstmt);
		}
		return r;

	}

	/* 데이터 삭제 : delete() */
	public void delete(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		

		try {
			con = pool.getConnection();
			sql = "delete from comment_tbl where idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			 pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			pool.freeClose(con, pstmt);
		}
		
	}

	/* 댓글 추가 */
	public void insert(CommentDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = pool.getConnection();
			sql = "insert into comment_tbl(idx,name,password,content,ref,rdate) values (seq_comment.nextval,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			System.out.println(dto.getName());
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getRef());
			pstmt.executeQuery();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			pool.freeClose(con, pstmt);
		}
	
	}

	/* 댓글의 갯수 리스트 구하기 */
	public int getCount(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int r = 0;

		try {
			con = pool.getConnection();
			sql = "select count(*) from comment_tbl whrer ref=?";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				r = rs.getInt(1);
			}

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			pool.freeClose(con, pstmt, rs);
		}
		return r;
	}

	public ArrayList<CommentDTO> getList(int ref) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<CommentDTO> list = new ArrayList<>();

		try {
			con = pool.getConnection();
			sql = "select * from comment_tbl where ref=? order by idx desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ref);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
					CommentDTO dto = new CommentDTO();
					dto.setIdx(rs.getInt("idx"));
					dto.setRef(rs.getInt("ref"));
					dto.setName(rs.getString("name"));
					dto.setPassword(rs.getString("password"));
					dto.setContent(rs.getString("content"));
					dto.setRdate(rs.getString("rdate"));
					
					list.add(dto);
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			pool.freeClose(con, pstmt, rs);
		}
		System.out.println(list.size());
		return list;
	}

}
