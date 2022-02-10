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
 * Servlet implementation class ReplyController
 */
@WebServlet("/reply")
public class ReplyController extends HttpServlet {
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
		int parentCode = Integer.parseInt(request.getParameter("code"));	//부모의 글번호
		String childTitle = request.getParameter("title");
		String childContent = request.getParameter("content");
		String childId = request.getParameter("id");
		
		ReportDAO dao = ReportDAO.getInstance();
		
		ReportDTO parentDTO = new ReportDTO();
		parentDTO = dao.getW(parentCode);		//부모의 글번호로 부모 DTO 가져오기
		
		ReportDTO childDTO = new ReportDTO();	//자식(답글) DTO 생성
		childDTO.setTitle(childTitle);
		childDTO.setContent(childContent);
		childDTO.setId(childId);
		
		dao.replyUpdate(parentDTO);
		dao.insertReply(childDTO, parentDTO);
		
		response.sendRedirect("list_in");
	}

}
