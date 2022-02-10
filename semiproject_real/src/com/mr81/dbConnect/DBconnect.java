package com.mr81.dbConnect;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DBconnect {

	public static DBconnect db = null;

	private DBconnect() {
		// TODO Auto-generated constructor stub
	}

	public static DBconnect getInstance() {
		if (db == null) {
			db = new DBconnect();

		}
		return db;
	}

	public Connection get_Instance() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String id = "mr81";
		String pwd = "0307";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("db 커넥트 에러 발생 아이디 드라이버 비밀번호 확인" + e.getMessage());

		}

		return conn;
	}

	// just insert, delete , update
	public void freeClose(Connection conn, Statement stmt) {

		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			System.out.println("객체 닫기오류" + e.getMessage());

		}

	}

	// just select
	public void freeClose(Connection conn, Statement stmt, ResultSet rs) {

		try {

			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("객체 닫기오류" + e.getMessage());

		}

	}

}
