<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	User user = new User(id, pw);
	
	Map<String, String> map = new HashMap<>();
	map.put("user1", "1111");
	map.put("user2", "1111");
	map.put("user3", "1111");
	
	if (session.getAttribute("loginUser") == null) {  // 비로그인 상태이면,
		if (map.containsKey(user.getId())) {
			if (map.get(user.getId()).equals(user.getPw())) {
				session.setAttribute("loginUser", user);
			} else {  // 로그인 실패(비밀번호가 틀렸음)
				response.sendRedirect("/06_SESSION/ex03/01_cart_A.jsp");
			}
		} else {  // 로그인 실패(아이디가 틀렸음)
			response.sendRedirect("/06_SESSION/ex03/01_cart_A.jsp");
		}
	}
	
%>
