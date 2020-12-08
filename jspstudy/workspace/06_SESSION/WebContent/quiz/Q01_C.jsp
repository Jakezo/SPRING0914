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
		session.setAttribute("player", request.getParameter("player"));
		
		// 세션에 저장된 3개 꺼내기
		String name = (String)session.getAttribute("name");
		String talent = (String)session.getAttribute("talent");
		String player = (String)session.getAttribute("player");
	%>
	
	<h3><%=name%>님의 선호도 조사 결과</h3>
	<ul>
		<li>좋아하는 연예인: <%=talent%></li>
		<li>좋아하는 운동선수: <%=player%></li>
	</ul>
	
	<br/>
	<input type="button" value="처음부터 다시하기"
	       onclick="location.href='Q01_A.jsp'" />

</body>
</html>