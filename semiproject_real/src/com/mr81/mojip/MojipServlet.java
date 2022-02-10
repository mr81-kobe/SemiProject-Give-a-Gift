package com.mr81.mojip;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.mr81.dao.semiDAO;

import ScheduelMethod.ScDTO;
import ScheduelMethod.ScheduelMethod;
import ScheduelMethod.mySch;

/**
 * Servlet implementation class MojipServlet
 */
@WebServlet("/mojip")
public class MojipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ScheduelMethod sm = new ScheduelMethod();
		request.setCharacterEncoding("UTF-8");
		String url = "";
		String command = request.getParameter("command");
		HttpSession session = request.getSession();
		System.out.println(command);
		semiDAO dao = semiDAO.getInstance();
		if (command == null) {
			System.out.println("null 뚫고 옴");

			ArrayList<MojipDTO> list = dao.showAllList();
			url = "Mojip/list.jsp";
			request.setAttribute("mo_list", list);
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);

		} else if (command.equals("insert")) {
			MojipDTO dto = new MojipDTO();

			String id = (String) session.getAttribute("userid");
			//마이 스케줄 느낌
		
			System.out.println("아이디" + id);
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String tag = (String) session.getAttribute("tag");
			String startdate = request.getParameter("startDate");
			String enddate = request.getParameter("endDate");
			String[] week = request.getParameterValues("week"); 
			
			String class_time = request.getParameter("class_time"); // 교시 값
			String each_time = request.getParameter("class"); // t들어간 시간 값
			String student = request.getParameter("student");
			String img = "default.jpg";
			int std = Integer.parseInt(student);
			String week_ = "";
			
			
			for (int i = 0; i < week.length; i++) {
				
				week_ += (week[i] + "/");
			
			}
			System.out.println(week_);
			dto.setClass_time(class_time);
			dto.setContent(content);
			dto.setEach_time(each_time);
			dto.setEnddate(enddate);
			dto.setId(id);
			dto.setStartdate(startdate);
			dto.setStudent(std);
			dto.setTag(tag);
			dto.setTitle(title);
			dto.setWeek(week_);
			dto.setImg(img);
			dao.insert(dto);
			dao.get_mo(title);
			// detail
			MojipDTO dto_ti = new MojipDTO();
			
			
			dto_ti = dao.get_mo(title);
			System.out.println("dto_ti.getEach_time()"+dto_ti.getEach_time());
			request.setAttribute("m", dto_ti);
		
			String[] time = sm.get_time(dto_ti.getEach_time());
			
			String date = sm.get_During(dto_ti.getStartdate(), dto_ti.getEnddate()); // 날짜 목록
			
			String date_trans = sm.get_week(dto_ti.getWeek().split("/"), date); // 요일에 맞는 날짜 목록 문자열로 옮김
			String[] date_final = date_trans.split("/");// 배열화
			ArrayList<ScDTO> list_date = new ArrayList<>();
			for (int i = 0; i < date_final.length; i++) {
				ScDTO sc = new ScDTO();
				System.out.println(date_final[i]);
				sc.setStart(date_final[i] + time[0]);
				sc.setEnd(date_final[i] + time[1]);
				list_date.add(sc);

			}  
			
			
			
			request.setAttribute("list_m", dao.get_ClassOfMine(id,title));
			int cur_student=dao.get_count(title);	
			request.setAttribute("cur_student", cur_student);
			request.setAttribute("t_list", list_date);
			url = "Mojip/detail.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);

		} else if (command.equals("detail")) {
			MojipDTO dto_ti = new MojipDTO();
			String title = request.getParameter("title");
			System.out.println(title);
			dto_ti = dao.get_mo(title);
			System.out.println("dto_ti.getEach_time()"+dto_ti.getEach_time());
			request.setAttribute("m", dto_ti);
			
			String[] time = sm.get_time(dto_ti.getEach_time());

			String date = sm.get_During(dto_ti.getStartdate(), dto_ti.getEnddate()); // 날짜 목록
			String date_trans = sm.get_week(dto_ti.getWeek().split("/"), date); // 요일에 맞는 날짜 목록 문자열로 옮김
			String[] date_final = date_trans.split("/");// 배열화
			ArrayList<ScDTO> list_date = new ArrayList<>();
			for (int i = 0; i < date_final.length; i++) {
				ScDTO sc = new ScDTO();
				System.out.println(date_final[i]);
				sc.setStart(date_final[i] + time[0]);
				sc.setEnd(date_final[i] + time[1]);
				list_date.add(sc);

			}  
			
			String id =(String)session.getAttribute("userid");
			
			request.setAttribute("list_m", dao.get_ClassOfMine(id,title));
			int cur_student=dao.get_count(title);	
			request.setAttribute("cur_student", cur_student);
			request.setAttribute("t_list", list_date);
			url = "Mojip/detail.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			
		}else if(command.equals("my")) {
			
			//학생
			MojipDTO dto = new MojipDTO();

			String id = (String) session.getAttribute("userid");
			//마이 스케줄 느낌
			ArrayList<MojipDTO> list = dao.showIdList(id); 
			
			ArrayList<mySch> my_list = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				mySch my = new mySch();
				String time = list.get(i).getEach_time();
				String date = sm.get_During(list.get(i).getStartdate(), list.get(i).getEnddate()); // 날짜 목록
				String date_trans = sm.get_week(list.get(i).getWeek().split("/"), date); // 요일에 맞는 날짜 목록 문자열로 옮김
				my.setDate_trans(date_trans); 
				my.setTime(time);
				my.setTitle(list.get(i).getTitle());
				System.out.println(list.get(i).getTitle());
				my_list.add(my); 
				
			}
			request.setAttribute("list", my_list);
			url="Mojip/insert_form.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(url); 
			rd.forward(request, response);
		}else if(command.equals("update_form")) {
			String update=request.getParameter("title");
			 
			request.setAttribute("dto",dao.get_mo(update) );
			RequestDispatcher rd = request.getRequestDispatcher("Mojip/update_form.jsp"); 
			rd.forward(request, response);
		}else if(command.equals("update")) {
			String title = request.getParameter("title"); 
			String title_send = URLEncoder.encode(request.getParameter("title"),"UTF-8");
			String content = request.getParameter("content"); 
			String starDate =request.getParameter("starDate");
			String endDate =request.getParameter("endDate");
			String [] week_ = request.getParameterValues("week"); 
			int student = Integer.parseInt(request.getParameter("student"));
			
			String week="";
			for(int i=0; i<week_.length; i++) {
				week=week_[i]+"/";
			System.out.println("ㅎ2");	
				
			}
			boolean opt=dao.update_Mojip(content, starDate, endDate,week, student,title);
				
				response.sendRedirect("mojip?command=detail&title="+title_send);
			
			
		
		}else if(command.equals("delete")) {
			String title=request.getParameter("title");
			
			dao.delete_mojip(title);
			response.sendRedirect("mojip");
			
		}
	
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
