package com.lnh.semi.report.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lnh.semi.report.dao.ReportDAO;
import com.lnh.semi.report.dto.ReportDTO;

/**
 * Servlet implementation class ListController2
 */
@WebServlet("/list_in")
public class ListController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page_ = request.getParameter("page");
		int page = 1;
		if(page_!=null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		String url = "report/list.jsp";
		
		ReportDAO dao = ReportDAO.getInstance();
		ArrayList<ReportDTO> list = new ArrayList<ReportDTO>();
		list = dao.getList(page);
		int count = dao.getListCount();
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
