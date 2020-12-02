package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz03")
public class Quiz03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Quiz03() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request는 사용하기 전에 인코딩부터 해 줍니다.
		request.setCharacterEncoding("UTF-8");
				
		// 요청 정보(파라미터)들을 request에서 꺼냅니다.
		// 정수나 실수는 알맞게 parsing 해 줍니다.
		// parsing을 안 해주면 연산(+, / 등) 이 안 됩니다.
		int kor = 0, eng = 0, mat = 0;
		String strKor = request.getParameter("kor");
		String strEng = request.getParameter("eng");
		String strMat = request.getParameter("mat");
		if ( strKor != null && !strKor.isEmpty()) {
			kor = Integer.parseInt(request.getParameter("kor"));
		}
		if ( strEng != null && !strEng.isEmpty()) {
			eng = Integer.parseInt(request.getParameter("eng"));
		}
		if ( strMat != null && !strMat.isEmpty()) {
			mat = Integer.parseInt(request.getParameter("mat"));
		}
		String name = request.getParameter("name");
		double prev_average = Double.parseDouble(request.getParameter("prev_average"));
		
		// 연산을 수행합니다.
		double average = (kor + eng + mat) / 3.0;
		char grade = 0;
		if ( average >= 90 ) { grade = 'A'; }
		else if ( average >= 80 ) { grade = 'B'; }
		else if ( average >= 70 ) { grade = 'C'; }
		else if ( average >= 60 ) { grade = 'D'; }
		else { grade = 'F'; }
		
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
		out.println(name + "의 평균은 " + average + "점이고, 학점은 " + grade + "학점이다.<br/>");
		out.println("지난 시험의 평균은 " + prev_average + "점으로 이번 평균과 " + (average - prev_average) + "점의 차이가 있다.");
		out.println("</body>");
		out.println("</html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}