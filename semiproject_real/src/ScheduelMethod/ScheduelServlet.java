package ScheduelMethod;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mr81.dao.semiDAO;

/**
 * Servlet implementation class ScheduelServlet
 */
@WebServlet("/sche")
public class ScheduelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		semiDAO dao = semiDAO.getInstance();
		String json = request.getParameter("json");
		ScheduelMethod sm = new ScheduelMethod();
		JSONParser jp = new JSONParser();// 파싱에 필요한 객체 소환
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		try {
			JSONObject jsonObj = (JSONObject) jp.parse(json);

			HttpSession session = request.getSession();
			int student = Integer.parseInt((String) jsonObj.get("student"));
			String over_title="";
			String title = (String) jsonObj.get("title");
			String title_ = URLEncoder.encode(title, "UTF-8");

			String teacher = (String) jsonObj.get("teacher");
			String startdate = (String) jsonObj.get("startdate");
			String enddate = (String) jsonObj.get("enddate");
			String week = (String) jsonObj.get("week");
			System.out.println("타이틀 스케줄 서블릿:" + title);
			String id = (String) session.getAttribute("userid");

			ArrayList<mySch> list = dao.get_Scheduel_fromid(id); // 아이디에 따른 스케줄 구하기

			String date = sm.get_During(startdate, enddate); // 이건 걍 문자
			String[] date_trans = sm.get_week(week.split("/"), date).split("/"); // 문자열이였는데 스플릿 한거고 (요일 날짜 문자열.스플릿 한거고
				loop:															// ,date 는 문자열
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < date_trans.length; j++) {
						
					String[] date_id = list.get(i).getDate_trans().split("/");
					for(int k=0; k<date_id.length; k++) {
					if (date_trans[j].equals(date_id[k])) {
						over_title=list.get(i).getTitle();
						break loop;
					}
					}
				}

			}
			System.out.println(over_title);
			String mes="";
			  
			  
			
			 
				 
			  int res=dao.scheduel_Overlap(title, id); //중복된 스케줄을 신청하는 지에 대한 유무 
			  if(res<1 && over_title =="" ) {
			  dao.scheduel_in(title,id,teacher);
			  mes ="일정이 추가되었습니다";
			 }else {
				  mes="이미 신청한 수업입니다.";
			 }
			  JSONObject jsonOb = new JSONObject();
			  jsonOb.put("title",title );
			 jsonOb.put("teacher",teacher ); 
			 jsonOb.put("id",id ); 
			 jsonOb.put("over_title", over_title);
			 jsonOb.put("mes", mes);
			 String json2=jsonOb.toJSONString();
			  out.print(json2);
			 

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
