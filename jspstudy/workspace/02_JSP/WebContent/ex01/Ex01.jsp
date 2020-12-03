<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- JSP에서 자바코드를 포함하려면 스크립트릿을 이용합니다. -->
	
	<% int a = 10; %>  <!-- 여기가 스크립트릿입니다. 여기는 자바영역입니다. -->

	<% if (a > 0) { %>
		<h3>양수</h3>
	<% } else { %>
		<h3>음수</h3>
	<% } %>


</body>
</html>




