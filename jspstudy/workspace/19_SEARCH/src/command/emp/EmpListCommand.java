package command.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import common.PathNRedirect;
import dao.EmpDao;

public class EmpListCommand implements Command {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("list", EmpDao.getInstance().list());
		
		PathNRedirect pathNRedirect = new PathNRedirect();
		pathNRedirect.setPath("emp/listPage.jsp");
		pathNRedirect.setRedirect(false);
		return pathNRedirect;
		
	}

}
