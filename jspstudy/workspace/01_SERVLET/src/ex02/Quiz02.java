package ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz02")
public class Quiz02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Quiz02() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request는 사용하기 전에 인코딩부터 해 줍니다.
		request.setCharacterEncoding("UTF-8");
		
		// 요청 정보(파라미터)들을 request에서 꺼냅니다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobbies");
		String address = request.getParameter("address");
		String[] jobs = request.getParameterValues("jobs");
		String memo = request.getParameter("memo");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		
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
		out.println("<ul>");
		out.println("<li>아이디: " + id + "</li>");
		out.println("<li>비밀번호: " + pw + "</li>");
		out.println("<li>성별: " + gender + "</li>");
		if ( hobbies == null ) {
			out.println("<li>취미: [없음]</li>");
		} else {
			out.println("<li>취미: " + Arrays.toString(hobbies) + "</li>");
		}
		out.println("<li>주소: " + address + "</li>");
		if ( jobs == null ) {
			out.println("<li>직업: [없음]</li>");
		} else {
			out.println("<li>직업: " + Arrays.toString(jobs) + "</li>");
		}
		out.println("<li><pre>메모: " + memo + "</pre></li>");
		out.println("<li>키: " + height + "</li>");
		out.println("<li>몸무게: " + weight + "</li>");	
		out.println("</ul>");	
		out.println("</body>");
		out.println("</html>");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}