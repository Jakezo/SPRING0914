<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 예외가 발생하면 Q05_C.jsp로 자동으로 이동됩니다. --%>
<%@ page errorPage="Q05_C.jsp" %>  <%-- 현재 파일과 동일한 경로이므로 파일명만 작성해도 됩니다. --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		int result = Integer.parseInt(request.getParameter("result"));
		String operator = request.getParameter("operator");
		
		int answer = 0;
		switch (operator) {
		case "+": answer = a + b; break;
		case "-": answer = a - b; break;
		case "*": answer = a * b; break;
		case "/": answer = a / b; break;
		case "%": answer = a % b; break;
		}
		
		String message = "";
		if (result == answer) {
			message += (a + operator + b + "=" + result + "<br/>정답입니다.</br/>");
		} else {
			message += ("제출: " + a + operator + b + "=" + result + "<br/>");
			message += ("정답: " + a + operator + b + "=" + answer + "<br/>");
		}
	%>

	<%=message%>
	<br/><br/>
	<a href="/02_JSP/quiz/Q05_A.jsp">다시풀기</a>

</body>
</html>