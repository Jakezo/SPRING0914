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
		session.setAttribute("name", request.getParameter("name"));
		session.setAttribute("talent", request.getParameter("talent"));
	%>
	<form action="Q01_C.jsp">
		<h3>2. 좋아하는 운동선수는 누구인가요?</h3>
		<input type="text" name="player" />
		<button>다음</button>
	</form>

</body>
</html>