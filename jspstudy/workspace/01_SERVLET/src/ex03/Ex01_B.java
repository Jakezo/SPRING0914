package ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex01_B")
public class Ex01_B extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Ex01_B() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// request는 인코딩부터 합시다.
		request.setCharacterEncoding("UTF-8");
	
		// request로 전달된 파라미터 저장합시다.
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		// response 생성
		// 1. content-type, charset
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		// 2. 출력스트림 생성
		PrintWriter out = response.getWriter();
		// 3. 출력할 내용 만들기
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>제목</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>이름: " + name + "</h3>");
		out.println("<h3>나이: " + age + "</h3>");

		// 이름과 나이를 다시 Ex01_C.java 서블릿 파일로 보내고 싶다.
		out.println("<h3><a href=\"/01_SERVLET/Ex01_C?name=" + name + "&age=" + age + "\">이동</a></h3>");
		out.println("</body>");
		out.println("</html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}