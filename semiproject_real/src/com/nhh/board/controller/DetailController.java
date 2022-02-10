package com.nhh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nhh.board.dao.BoardDAO;
import com.nhh.board.dao.CommentDAO;
import com.nhh.board.dto.BoardDTO;
import com.nhh.board.dto.CommentDTO;

@WebServlet("/detail_nh")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String url = "nh_board/detail.jsp";
		response.setContentType("text/html; chartset=UTF-8");
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = new BoardDTO();
		dto = dao.readW(no);
	
		CommentDAO cdao=CommentDAO.getInstance();
		ArrayList<CommentDTO> clist=cdao.getList(no);
		HttpSession seesion = request.getSession(); 
		seesion.setAttribute("clist", clist);
		seesion.setAttribute("dto", dto);
		
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
