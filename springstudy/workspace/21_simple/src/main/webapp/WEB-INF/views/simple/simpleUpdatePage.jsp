<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>수정 페이지입니다.</h3>
	
	번호: ${simpleDto.no}<br/><br/>
	제목<br/>
	<input type="text" name="title" value="${simpleDto.title}" /><br/><br/>
	내용<br/>
	<input type="text" name="content" value="${simpleDto.content}" /><br/><br/>
	

</body>
</html>