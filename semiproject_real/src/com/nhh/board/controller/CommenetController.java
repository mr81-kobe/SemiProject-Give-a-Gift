package com.nhh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhh.board.dao.CommentDAO;
import com.nhh.board.dto.CommentDTO;


@WebServlet("/commenet")
public class CommenetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			
			String url="";					
			int idx=Integer.parseInt(request.getParameter("no")); 		//ref
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String content=request.getParameter("content");
			String mes=request.getParameter("mes");		// 명령어
			String cno=request.getParameter("cno");
			
			int	 cno2=0;
			
			CommentDTO dto=new CommentDTO();
			CommentDAO dao=CommentDAO.getInstance();
					
				dto.setRef(idx);
				dto.setContent(content);
				dto.setName(name);
				dto.setPassword(password);
				if(mes.equals("insert")) {
				dao.insert(dto);
				}else if(mes.equals("delete")) {
					if(cno!=null) {
						 cno2=Integer.parseInt(cno);
						}
				dao.delete(cno2);
				}
				url="detail_nh?no="+idx;
			response.sendRedirect(url);	
	}

}
