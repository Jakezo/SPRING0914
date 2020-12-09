<%@page import="xxxxx.Person"%>
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
	%>
	
	<%-- 1. tag로 bean 생성 --%>
	<%--
	<jsp:useBean id="p" class="xxxxx.Person" />
	<jsp:setProperty property="*" name="p" />
	--%>
	
	<%-- 2. java로 bean 생성(추천) --%>
	<%
		Person p = new Person();
		p.setName(request.getParameter("name"));
		p.setAge(Integer.parseInt(request.getParameter("age")));
		p.setGender(request.getParameter("gender").charAt(0));
		
		// EL 사용을 위해서 pageContext에 올려둔다.
		pageContext.setAttribute("p", p);
	%>
	
	<h3>이름: ${p.name}</h3>
	<h3>나이: ${p.age}</h3>
	<h3>성별: ${p.gender}</h3>
	
	<%-- 바로 위 코드와 같은 코드입니다.
	<h3>이름: ${p.getName()}</h3>
	<h3>나이: ${p.getAge()}</h3>
	<h3>성별: ${p.getGender()}</h3>
	--%>
</body>
</html>