package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PathNRedirect;
import dao.WhiteDao;
import dto.WhiteDto;

public class WhiteContentCommand implements WhiteCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) {
		
		String query = request.getParameter("query");
		
		List<WhiteDto> list = WhiteDao.getInstance().contentList(query);
		request.setAttribute("list", list);
		
		PathNRedirect pathNRedirect = new PathNRedirect();
		pathNRedirect.setPath("white/listPage.jsp");
		pathNRedirect.setRedirect(false);
		
		return pathNRedirect;
		
	}

}
