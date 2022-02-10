package com.mr81.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mr81.Kakao.KakaoDTO;
import com.mr81.dbConnect.DBconnect;
import com.mr81.mojip.MojipDTO;

import ScheduelMethod.ScheduelMethod;
import ScheduelMethod.mySch;

public class semiDAO {
	public static semiDAO dao = null;

	private semiDAO() {
		// TODO Auto-generated constructor stub
	}

	public static semiDAO getInstance() {
		if (dao == null) {
			dao = new semiDAO();

		}
		return dao;
	}

	// 로그인 가능한 아이디 인지 확인 해보자
	// ?;
	public boolean login_Id(String id) { // 로그인 체크
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
			} else {
				login = false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("아이디 체크 오류" + e.getMessage());
		} finally {
			db.freeClose(conn, pstmt, rs);
		}

		return login;
	}

	public ArrayList<KakaoDTO> get_ClassOfMine(String id, String title) { // 학생리스트 가져오기

		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "";
		System.out.println("id" + id);
		System.out.println("title" + title);
		ArrayList<KakaoDTO> list = new ArrayList<>();
		try {

			sql = "select kakao.* from kakao , scheduel_in where kakao.id = scheduel_in.id and scheduel_in.teacher = ? and scheduel_in.title = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				KakaoDTO dto = new KakaoDTO();
				dto.setId(rs.getString("id"));
				dto.setNick(rs.getString("nick"));
				dto.setTime(rs.getString("TIME_DATA"));
				list.add(dto);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("아이디 체크 오류" + e.getMessage());
		} finally {
			db.freeClose(conn, pstmt, rs);
		}
		System.out.println("list_size: " + list.size());
		return list;
	}

	public boolean regist_member(KakaoDTO dto) { // 회원가입
		boolean login = false;
		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();

		PreparedStatement pstmt = null;
		String sql = "";

		try {

			sql = "INSERT INTO (id,tag,nick,pwd,yn) VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getTag());
			pstmt.setString(3, dto.getNick());
			pstmt.setString(4, dto.getPwd());
			pstmt.setString(5, dto.getYn());
			int ret = pstmt.executeUpdate();
			if (ret > 0) {
				login = true;

			} else {
				login = false;
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			db.freeClose(conn, pstmt);
		}

		return login;
	}

	public ArrayList<MojipDTO> showAllList() { // 모집 리스트 dao

		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MojipDTO> list = new ArrayList<>();

		String sql = "";

		try {

			sql = "select * from mojip";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MojipDTO dto = new MojipDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setTag(rs.getString("tag"));
				dto.setTime(rs.getString("time"));
				dto.setTitle(rs.getString("title"));

				list.add(dto);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("리스트 보기 에러 발생" + e.getMessage());
		} finally {
			db.freeClose(conn, pstmt, rs);
		}

		return list;
	}

	public String get_tag(String id) { // 테그 값 가져오기 선생 학생 나누기

		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "";
		String res = "none";
		try {

			sql = "SELECT tag FROM kakao WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				res = rs.getString("tag");

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("아이디 체크 오류" + e.getMessage());
		} finally {
			db.freeClose(conn, pstmt, rs);
		}

		return res;
	}

	public void insert(MojipDTO dto) { // 모집 테이블 글 쓰기
		boolean login = false;
		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();
		PreparedStatement pstmt = null;

		String sql = "";

		try {

			sql = "INSERT INTO mojip(no,id,title,content,tag,stardate,enddate,week,class_time,each_time,img,student) VALUES (seq_mojip.nextval, ? ,? ,? ,? ,? ,? ,? ,? ,? ,? , ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getTag());
			pstmt.setString(5, dto.getStartdate());
			pstmt.setString(6, dto.getEnddate());
			pstmt.setString(7, dto.getWeek());
			pstmt.setString(8, dto.getClass_time());
			pstmt.setString(9, dto.getEach_time());
			pstmt.setString(10, dto.getImg());
			pstmt.setInt(11, dto.getStudent());

			int ret = pstmt.executeUpdate();
			if (ret > 0) {
				System.out.println("게시글 쓰기 성공");
			}

		} catch (Exception e) {
			// TODO: handle exception

			System.err.println("모집 게시판 입력 오류: " + e.getMessage());
		} finally {
			db.freeClose(conn, pstmt);
		}

	}

	public MojipDTO get_mo(String no) { // 하나의 모집 게시글 가져오기
		MojipDTO dto = new MojipDTO();

		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		try {

			sql = "select * from mojip where title=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setContent(rs.getString("CONTENT"));
				dto.setEach_time(rs.getString("EACH_TIME"));
				dto.setStartdate(rs.getString("STARDATE"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setTime(rs.getString("TIME"));
				dto.setEnddate(rs.getString("ENDDATE"));
				dto.setWeek(rs.getString("WEEK"));
				dto.setTag(rs.getString("TAG"));
				dto.setId(rs.getString("ID"));
				dto.setStudent(rs.getInt("STUDENT"));

			}

		} catch (Exception e) {
			// TODO: handle exception

			System.err.println("모집 게시판 조회 오류: " + e.getMessage());
		} finally {
			db.freeClose(conn, pstmt, rs);
		}
		return dto;

	}

	public ArrayList<MojipDTO> get_myscheduel(String id) { // 내가 신청한 스케줄 가져오기

		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MojipDTO> mo_list = new ArrayList<>();

		String sql = "";

		try {

			sql = "select mojip.* from mojip ,scheduel_in  where mojip.id = scheduel_in.teacher and scheduel_in.id= ? and mojip.title=scheduel_in.title";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MojipDTO dto = new MojipDTO();
				dto.setContent(rs.getString("CONTENT"));
				dto.setEach_time(rs.getString("EACH_TIME"));
				dto.setStartdate(rs.getString("STARDATE"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setTime(rs.getString("TIME"));
				dto.setEnddate(rs.getString("ENDDATE"));
				dto.setWeek(rs.getString("WEEK"));
				dto.setTag(rs.getString("TAG"));
				dto.setId(rs.getString("ID"));
				dto.setStudent(rs.getInt("STUDENT"));
				mo_list.add(dto);
			}

		} catch (Exception e) {
			// TODO: handle exception

			System.err.println("모집 게시판 조회 오류: " + e.getMessage());
		} finally {
			db.freeClose(conn, pstmt, rs);
		}
		return mo_list;

	}

	public boolean scheduel_in(String title, String id, String teacher) {// 스케줄 신청

		boolean login = false;
		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();
		PreparedStatement pstmt = null;

		String sql = "";

		try {

			sql = "INSERT INTO scheduel_in VALUES (SCHEDUEL_SEQ.nextval, ? ,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, title);
			pstmt.setString(2, id);
			pstmt.setString(3, teacher);

			int ret = pstmt.executeUpdate();
			if (ret > 0) {
				System.out.println("스케줄 인원 추가 성공");
			}

		} catch (Exception e) {
			// TODO: handle exception

			System.err.println("스케줄 인원 추가: " + e.getMessage());
		} finally {
			db.freeClose(conn, pstmt);
		}

		return login;

	}

	public int get_count(String title) { // 현재 신청한 인원 구하기

		int res = 0;
		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		try {

			sql = "select COUNT( *)  from scheduel_in where TITLE=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				res = rs.getInt("COUNT(*)");
			}

		} catch (Exception e) {
			// TODO: handle exception

			System.err.println("인원수 확인 오류: " + e.getMessage());
		} finally {
			db.freeClose(conn, pstmt, rs);
		}

		return res;
	}

	public int scheduel_Overlap(String title, String id) {// 중복 스케줄 체크

		int res = 0;
		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		try {

			sql = "select COUNT(*)  from scheduel_in where TITLE=? and id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				res = rs.getInt("COUNT(*)");
			}

		} catch (Exception e) {
			// TODO: handle exception

			System.err.println("인원수 확인 오류: " + e.getMessage());
		} finally {
			db.freeClose(conn, pstmt, rs);
		}

		return res;

	}

	public ArrayList<mySch> get_Scheduel_fromid(String id) { // 학생입장에서의 자신의 수업 가져오기

		int res = 0;
		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<mySch> list = new ArrayList<>();
		String sql = "";

		try {

			sql = "select mojip.* from mojip ,scheduel_in  where mojip.id = scheduel_in.teacher and scheduel_in.id=? and mojip.title=scheduel_in.title";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				mySch my = new mySch();
				String start = rs.getString("stardate");
				String end = rs.getString("enddate");
				String title_ = rs.getString("title");
				String week = rs.getString("week");
				ScheduelMethod sm = new ScheduelMethod();

				String date = sm.get_During(start, end);
				String date_trans = sm.get_week(week.split("/"), date); // 요일에 맞는 문자열
				my.setTitle(title_);
				my.setDate_trans(date_trans);
				list.add(my);

			}

		} catch (Exception e) {
			// TODO: handle exception

			System.err.println("그 인원의 스케줄 확인 메소드 오류 " + e.getMessage());
		} finally {
			db.freeClose(conn, pstmt, rs);
		}

		return list;

	}

	public KakaoDTO get_Member(String id) { // id에 따른 회원 가져오기

		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "";
		KakaoDTO dto = new KakaoDTO();
		try {

			sql = "SELECT * FROM kakao WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setTag(rs.getString("tag"));
				dto.setId(id);
				dto.setNick(rs.getString("NICK"));
				dto.setTime(rs.getString("TIME_DATA"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("아이디 체크 오류" + e.getMessage());
		} finally {
			db.freeClose(conn, pstmt, rs);
		}

		return dto;
	}

	public ArrayList<MojipDTO> showIdList(String id) { // 선생 입장에서의 내가 쓴 모집글들 가져오기

		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MojipDTO> list = new ArrayList<>();

		String sql = "";

		try {

			sql = "select * from mojip where id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MojipDTO dto = new MojipDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setTag(rs.getString("tag"));
				dto.setTime(rs.getString("time"));
				dto.setTitle(rs.getString("title"));
				dto.setStartdate(rs.getString("stardate"));
				dto.setEnddate(rs.getString("enddate"));
				dto.setEach_time(rs.getString("each_time"));
				dto.setWeek(rs.getString("week"));
				dto.setContent(rs.getString("content"));
				dto.setStudent(rs.getInt("student"));
				list.add(dto);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("리스트 보기 에러 발생" + e.getMessage());
		} finally {
			db.freeClose(conn, pstmt, rs);
		}

		return list;
	}

	public boolean update_Mojip(String content, String starDate, String endDate, String week, int studetn,
			String title) {
		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();
		PreparedStatement pstmt = null;

		boolean opt = false;
		String sql = "";
		try {

			sql = "UPDATE mojip SET content =? , STARDATE =? , ENDDATE=? ,week=?, student =? where title =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setString(2, starDate);
			pstmt.setString(3, endDate);
			pstmt.setString(4, week);
			pstmt.setInt(5, studetn);
			pstmt.setString(6, title);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				System.out.println("update 성공!");
				opt = true;
			} else {
				System.out.println("update 실패!");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("업데이트" + e.getMessage());
		} finally {
			db.freeClose(conn, pstmt);
		}
		return opt;
	}

	public void delete_mojip(String title) {
		DBconnect db = DBconnect.getInstance();
		Connection conn = db.get_Instance();
		PreparedStatement pstmt = null;

		boolean opt = false;
		String sql = "";
		try {

			sql = "delete from mojip where title =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				System.out.println("delete 성공!");

			} else {
				System.out.println("delete 실패!");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("리스트 보기 에러 발생" + e.getMessage());
		} finally {
			db.freeClose(conn, pstmt);
		}

	}
}
