package com.mr81.mojip;

public class MojipDTO {
	
	private int no=0;
	private String id = null; 
	private String title =null;
	private String content =null; 
	private String tag =null; 
	private String startdate =null; 
	private String enddate =null; 
	private String time =null; //작성 시간 
	private String week=null; 
	private String class_time =null; //time class 값 문자열 
	private String each_time =null; //1교시 2교시 3교시 
	private String img = null;
	private int student = 0;
	private int cur_student=0;
	
	public MojipDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getClass_time() {
		return class_time;
	}

	public void setClass_time(String class_time) {
		this.class_time = class_time;
	}

	public String getEach_time() {
		return each_time;
	}

	public void setEach_time(String each_time) {
		this.each_time = each_time;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getStudent() {
		return student;
	}

	public void setStudent(int student) {
		this.student = student;
	}

	public int getCur_student() {
		return cur_student;
	}

	public void setCur_student(int cur_student) {
		this.cur_student = cur_student;
	}


	
	
}
