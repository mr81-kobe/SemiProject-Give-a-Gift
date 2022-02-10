package com.lnh.semi.report.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lnh.semi.report.dao.ReportDAO;
import com.lnh.semi.report.dto.ReportDTO;

/**
 * Servlet implementation class WriteController2
 */
@WebServlet("/write_in")
public class WriteController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
request.setCharacterEncoding("UTF-8");
		
		ReportDTO dto = new ReportDTO();
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setId(request.getParameter("id"));
		dto.setPassword(request.getParameter("password"));
		
		ReportDAO dao = ReportDAO.getInstance();
		dao.insertW(dto);
		
		response.sendRedirect("list_in");
	}

}
