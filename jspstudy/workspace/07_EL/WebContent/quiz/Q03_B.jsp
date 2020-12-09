<%@page import="bean.User"%>
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
		
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setAge(request.getParameter("age"));
		user.setGender(request.getParameter("gender"));
		user.setHobbies(request.getParameterValues("hobbies"));
		user.setAddress(request.getParameter("address"));
		user.setFavorites(request.getParameterValues("favorites"));
		
		pageContext.setAttribute("user", user);
	%>
	
	<ul>
		<li>이름: ${user.name}</li>
		<li>나이: ${user.age}</li>
		<li>성별: ${user.gender}</li>
		<li>취미: ${user.hobbies[0]} ${user.hobbies[1]} ${user.hobbies[2]} ${user.hobbies[3]}</li>
		<li>주소: ${user.address}</li>
		<li>좋아하는 음식: ${user.favorites[0]} ${user.favorites[1]} ${user.favorites[2]} ${user.favorites[3]}</li>
	</ul>
	
</body>
</html>