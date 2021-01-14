<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>선택한 ${simpleDto.no}번 게시글입니다.</h3>
	
	작성자: ${simpleDto.writer}<br/>
	제목: ${simpleDto.title}<br/>
	내용: ${simpleDto.content}<br/>
	작성일: ${simpleDto.regDate}<br/>

</body>
</html>