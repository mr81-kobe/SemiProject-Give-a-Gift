package com.nhh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhh.board.dao.BoardDAO;
import com.nhh.board.dto.BoardDTO;

@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "nh_board/search.jsp";
		String searchWord = request.getParameter("searchWord");
		
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		BoardDAO dao = BoardDAO.getInstance();
		list = dao.searchList(searchWord);
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
