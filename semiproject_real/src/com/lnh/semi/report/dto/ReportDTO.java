package com.lnh.semi.report.dto;

import java.sql.Date;

public class ReportDTO {

	private int code = 0;			//글번호
	private String id = null;		//작성자id
	private String password = null;	//글 비밀번호
	private String title = null;	//글제목
	private String content = null;	//글내용
	private int hit = 0;			//조회수
	private Date rdate = null;	//작성일
	private int boardGroup = 0;
	private int boardSequence = 0;
	private int boardLevel = 0;
	
	public ReportDTO() {
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public int getBoardGroup() {
		return boardGroup;
	}

	public void setBoardGroup(int boardGroup) {
		this.boardGroup = boardGroup;
	}

	public int getBoardSequence() {
		return boardSequence;
	}

	public void setBoardSequence(int boardSequence) {
		this.boardSequence = boardSequence;
	}

	public int getBoardLevel() {
		return boardLevel;
	}

	public void setBoardLevel(int boardLevel) {
		this.boardLevel = boardLevel;
	}

	
}
