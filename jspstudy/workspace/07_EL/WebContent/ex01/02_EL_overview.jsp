<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSP 표현식</h3>
	<ul>
		<li><%=7+2%></li>
		<li><%=7-2%></li>
		<li><%=7*2%></li>
		<li><%=7/2%></li><%-- 몫 --%>
		<li><%=7%2%></li>
	</ul>
	<h3>EL 표현언어</h3>
	<ul>
		<li>${7+2}</li>
		<li>${7-2}</li>
		<li>${7*2}</li>
		<li>${7/2}</li><%-- 나누기 --%>
		<li>${7%2}</li>
	</ul>
	
	<% int a = 10; %>
	<h3>JSP 표현식</h3>
	<h3><%=a%></h3>
	<h3>EL 표현언어</h3>
	<% pageContext.setAttribute("a", a); %>
	<h3>${a}</h3>
	
</body>
</html>