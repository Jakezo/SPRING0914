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
		session.setAttribute("id", request.getParameter("id"));
		session.setAttribute("pw", request.getParameter("pw"));
		session.setAttribute("name", request.getParameter("name"));
	%>

	<h3>이용 약관</h3>
	--------------------<br/>
	--------------------<br/>
	--------------------<br/>
	--------------------<br/>
	<form action="Q02_C.jsp" method="post">
		약관에 동의하십니까?<br/><br/>
		<input type="radio" name="agree" value="yes" />동의함
		<input type="radio" name="agree" value="no" />동의안함
		<button>회원가입</button>
	</form>
	
</body>
</html>






