package command;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Now {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		String result = hour + ":" + minute + ":" + second;
		request.setAttribute("result", result);
		
		return "view/now.jsp";
		
	}
	
}
