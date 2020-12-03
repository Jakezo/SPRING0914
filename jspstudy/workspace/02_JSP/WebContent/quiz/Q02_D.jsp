<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		String age = request.getParameter("age");
	%>
	<h3>성인</h3>
	<div>
		당신의 나이는 <%=age%>살이므로, 주류 구매가 가능합니다.
	</div>
	
	<br/><br/>
	<a href="/02_JSP/quiz/Q02_A.jsp">처음으로 이동</a>
	
</body>
</html>