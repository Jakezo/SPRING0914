<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션에 올라간 정보: loginUser, cart
	
	// 장바구니 비우기는 cart만 제거한다.
	session.removeAttribute("cart");

	// 쇼핑하러 이동
	response.sendRedirect("/06_SESSION/ex03/01_cart_B.jsp");
%>