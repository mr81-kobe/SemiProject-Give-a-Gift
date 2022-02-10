package com.mr81.Kakao;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mr81.dao.semiDAO;
import com.mr81.mojip.MojipDTO;

import ScheduelMethod.ScheduelMethod;
import ScheduelMethod.mySch;

/**
 * Servlet implementation class KakaoServlet
 */
@WebServlet("/kakao")
public class KakaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");// 카카오로 날라오는건 전부다 servlet
		System.out.println(command);
		String url = "";
		HttpSession session = request.getSession();  
		KakaoDAO dao = KakaoDAO.getInstance();
		if (command.equals("form")) {

			String json = request.getParameter("js");

			KakaoDTO dto = JsonUtil.getinform(json);
		
								
			if (!dao.login_Id(dto.getId())) {
				// return 값이 트루면 회원 else 인경우에는 회원가입이 필요함
				session.setAttribute("dto", dto);
				url = "Member/Regist.jsp";
				
			}else { 
				String tag=dao.get_tag(dto.getId());
				session.setAttribute("tag" , tag ); 
				session.setAttribute("userid",dto.getId() ); 
				
				url = "main.jsp";
			}
			
		}else if (command.equals("regist")) {
			KakaoDTO dto_re = new KakaoDTO();
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String nick = request.getParameter("nick");
			String yn = request.getParameter("yn");
			String tag_ = request.getParameter("tag");
			String tag = (tag_ == null) ? "none" : tag_;
			
			dto_re.setId(id);
			dto_re.setNick(nick);
			dto_re.setPwd(pwd);
			dto_re.setTag(tag);
			dto_re.setPwd(pwd);
			dto_re.setYn(yn);
			dao.regist_member(dto_re);
			session.setAttribute("userid",id ); 
			session.setAttribute("tag",tag ); 
			
			url ="main.jsp";
		
		}else if(command.equals("mypage")) {
			semiDAO dao_sm = semiDAO.getInstance(); 
			ScheduelMethod sm = new ScheduelMethod();
			String u_id=(String)session.getAttribute("userid");
			KakaoDTO dto=dao_sm.get_Member(u_id);
			session.setAttribute("dto", dto);
			ArrayList<MojipDTO> list=dao_sm.showIdList(u_id);//선생용
			ArrayList<mySch> my_list = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				mySch my = new mySch();
				String time = list.get(i).getEach_time();
				String date = sm.get_During(list.get(i).getStartdate(), list.get(i).getEnddate()); // 날짜 목록
				String date_trans = sm.get_week(list.get(i).getWeek().split("/"), date); // 요일에 맞는 날짜 목록 문자열로 옮김
				my.setDate_trans(date_trans); 
				my.setTime(time);
				my.setTitle(list.get(i).getTitle());
				
				my_list.add(my); 
				
			}
			
			for(int i =0;  i<list.size(); i++) {
			list.get(i).setCur_student(dao_sm.get_count(list.get(i).getTitle()));
			}
			session.setAttribute("sh_list", my_list);
			session.setAttribute("list", list);
			
			
			url ="myPage.jsp";
			
		}else if(command.equals("mypageForStudent")) {
			semiDAO dao_sm = semiDAO.getInstance(); 
			ScheduelMethod sm = new ScheduelMethod();
			String u_id=(String)session.getAttribute("userid");
			KakaoDTO dto=dao_sm.get_Member(u_id);
			session.setAttribute("dto", dto);
			ArrayList<MojipDTO> list=dao_sm.get_myscheduel(u_id);//선생용
			ArrayList<mySch> my_list = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				mySch my = new mySch();
				String time = list.get(i).getEach_time();
				String date = sm.get_During(list.get(i).getStartdate(), list.get(i).getEnddate()); // 날짜 목록
				String date_trans = sm.get_week(list.get(i).getWeek().split("/"), date); // 요일에 맞는 날짜 목록 문자열로 옮김
				my.setDate_trans(date_trans); 
				my.setTime(time);
				my.setTitle(list.get(i).getTitle());
				
				my_list.add(my); 
				
			}
			
			for(int i =0;  i<list.size(); i++) {
			list.get(i).setCur_student(dao_sm.get_count(list.get(i).getTitle()));
			}
			session.setAttribute("sh_list", my_list);
			session.setAttribute("list", list);
			
			url ="mypageForStudent.jsp";
		}
			
			
			
		
		response.sendRedirect(url);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
