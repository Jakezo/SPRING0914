<%@page import="java.sql.Date"%>
<%@page import="bean.Board"%>
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
		
		Board board = new Board();
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		board.setDate(new Date(System.currentTimeMillis()));
		
		pageContext.setAttribute("board", board);
	%>


	제목: ${board.title}<br/>
	작성: ${board.writer}<br/>
	내용: ${board.content}<br/>
	일자: ${board.date}<br/>


</body>
</html>







