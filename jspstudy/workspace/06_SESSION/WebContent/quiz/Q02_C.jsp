<%@page import="java.io.IOException"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String agree = request.getParameter("agree");
	
	boolean isSuccess = false;
	if (agree.equals("yes")) {
		String id = (String) session.getAttribute("id");
		String pw = (String) session.getAttribute("pw");
		String name = (String) session.getAttribute("name");
		String filename = id + ".txt";
		session.setAttribute("filename", filename);
		String realPath = request.getRealPath("/" + filename);
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(realPath));
			bw.write("가입아이디: " + id + "\n");
			bw.write("가입비밀번호: " + pw + "\n");
			bw.write("가입이름: " + name + "\n");
			isSuccess = true;
		} catch (IOException e) {
			isSuccess = false;
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (Exception e) { }
		}
	}
	session.setAttribute("isSuccess", isSuccess);
	response.sendRedirect("Q02_D.jsp");
%>
