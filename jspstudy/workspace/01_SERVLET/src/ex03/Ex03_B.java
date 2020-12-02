package ex03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex03_B")
public class Ex03_B extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Ex03_B() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 다른 페이지로 이동하는 방법 중에서 "포워드"라는 방법이 있습니다.
		// 포워드(forward)란 기존 request를 다른 페이지로 함께 보내주는 이동방법입니다.
		
		// request를 forward 해 주겠다.
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("Ex03_C");	// request를 다시 보낼 곳은 Ex03_C 입니다.
		dispatcher.forward(request, response);									// request를 다시 보냅니다.
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}