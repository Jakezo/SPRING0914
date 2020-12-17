package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GreenDao;
import dto.GreenDto;

public class GreenInsertCommand implements GreenCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		// DB에 삽입 후 결과를 request에 저장
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		GreenDto greenDto = new GreenDto();
		greenDto.setWriter(writer);
		greenDto.setTitle(title);
		greenDto.setContent(content);
		
		int result = GreenDao.getInstance().insert(greenDto);
		request.setAttribute("result", result);
		
		return "green/insertResult.jsp";
		
	}

}
