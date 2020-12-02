package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex03_request")
public class Ex03_request extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Ex03_request() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * request
		 * 
		 * 1. 사용자가 요청한 정보가 저장되는 객체이다.
		 * 2. request에 저장된 요청 정보는 "파라미터(parameter)"라고 한다.
		 * 3. 모든 파라미터의 타입은 String 또는 String[] 이다.
		 *    1) String value = request.getParameter("parameter")
		 *    2) String[] list = request.getParameterValues("parameter")
		 * 4. request를 이용해서 정보를 요청하는 방법
		 *    1) <form> 태그의 모든 폼 요소들은 submit하면 정보가 요청된다.
		 *       사용자: <input type="text" name="id" /> submit 하면
		 *       서버  : String id = request.getParameter("id");
		 *    2) URL에 파라미터를 포함한다.
		 *       URL : 호스트:포트번호/컨텍스트패스/URLMapping?파라미터=값&파라미터=값
		 */
		
		
		// 실행방법
		// Ctrl + F11로 실행을 하고 URL을 수정한다.
		// localhost:9090/01_SERVLET/Ex03_request     <- 이 주소를 아래와 같이 수정한다.
		// localhost:9090/01_SERVLET/Ex03_request?name=에밀리&age=20&address=서울시 마포구
		
		// request가 어떤 인코딩인지 모르므로
		// UTF-8로 설정하고 시작한다.
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터로 name, age, address가 전달된다.
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		
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
		out.println("<h3>주소: " + address + "</h3>");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
