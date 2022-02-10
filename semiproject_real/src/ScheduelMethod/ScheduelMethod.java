package ScheduelMethod;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ScheduelMethod {
public static DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 

	public ScheduelMethod() {
		// TODO Auto-generated constructor stub
	}

	
	
	public static String get_During(String stdate, String  endate) {
		String During="";
		try {
			Date st = df.parse(stdate);
			Date et = df.parse(endate); 
			Calendar stC = Calendar.getInstance();
			Calendar edC = Calendar.getInstance();
			stC.setTime(st);
			edC.setTime(et);
			while(stC.compareTo(edC)!=1) { //compareTo 날짜 비교 하는 date의 함수 
				String date=df.format(stC.getTime());
				
				During+=date+"/";
				stC.add(Calendar.DATE, 1);
			
			}
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return During;
	}//두 날짜사이의 날짜들 구하기 
	
	public static String get_week(String [] week, String days) {
		String eqaul="";
		String [] day =days.split("/");
		for(int i =0; i< week.length; i++) {
			Date date;
			try {
				
				for(int j=0; j<day.length; j++) {
				date = df.parse(day[j]);
				Calendar cal = Calendar.getInstance(); 
				cal.setTime(date);
			
				String weekend="";
				switch(cal.get(Calendar.DAY_OF_WEEK)) {
				case 1: 
					weekend ="일";
						break;
				case 2: 
					weekend ="월";
						break; 
				case 3: 
					weekend ="화";
						break;
				case 4: 
					weekend ="수";
						break;
				case 5: 
					weekend ="목";
						break;
				case 6: 
					weekend ="금";
						break;
				case 7: 
					weekend ="토";
						break;
				}
				if(week[i].equals(weekend)) {
					
				
					
					eqaul+=day[j]+"/";
					
				}
				
				}
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return eqaul;
	}	//해당하는 날짜 안에서 동일한 요일을 구한다.  
	
	public String [] get_time(String time) {
		
	String [] time_list	=time.split("~"); 
		
		return time_list;
	}

	
}
