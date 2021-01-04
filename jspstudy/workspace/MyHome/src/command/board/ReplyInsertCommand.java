package command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PathNRedirect;

public class ReplyInsertCommand implements BoardCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String mId = request.getParameter("mId");
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		String bIp = request.getRemoteAddr();
		
		String page = request.getParameter("page");
		
		
		return null;
	}

}
