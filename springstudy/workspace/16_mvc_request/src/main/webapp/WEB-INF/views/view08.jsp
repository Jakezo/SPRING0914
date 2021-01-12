<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>view08.jsp</h3>
	
	<%-- model이 저장한 속성(Controller에서 전달된 값) --%>
	<ul>
		<li>제목: ${title}</li>
		<li>조회수: ${hit}</li>
		<li>작성일: ${date}</li>
	</ul>

</body>
</html>