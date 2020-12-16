package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Gugudan {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		int startDan = Integer.parseInt(start);
		int endDan = Integer.parseInt(end);
		
		StringBuffer sb = new StringBuffer();
		for (int dan = startDan; dan <= endDan; dan++) {
			for (int n = 1; n <= 9; n++) {
				// sb.append(dan).append("x").append(n).append("=").append(dan*n).append("<br/>");
				sb.append(dan + "x" + n + "=" + (dan*n) + "<br/>");
			}
		}
		request.setAttribute("result", sb.toString());
		
		return "view/gugudan.jsp";
		
	}
	
}
