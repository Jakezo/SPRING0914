<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 업로드가 진행되는 곳 --%>
<%
	// request의 인코딩을 할 필요가 없다.
	// MultipartRequest 객체를 만들 때 인코딩을 한다.
	
	// 디렉토리명을 변수로 저장한다.
	String directory = "archive";

	// 디렉토리의 실제 경로를 알아낸다.
	String realPath = request.getRealPath(directory);
	
	// MultipartRequest 객체를 만든다. (이 때 업로드가 진행된다.)
	MultipartRequest multipart = new MultipartRequest(
			request,
			realPath,
			1024 * 1024 * 10,  // 업로드 크기 (10MB)
			"UTF-8",
			new DefaultFileRenamePolicy()  // 동일한 파일이 업로드되면 기존 파일명을 수정하는 방법이다.(원래 파일명에 숫자 붙이기)
			);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>업로드 결과</h3>
	<ul>
		<li>경로: <%=realPath%></li>
	</ul>

</body>
</html>
