<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>하나의 CONTROLL에게 요청하기</h3>
	<input type="button" value="한글인사요청하기" onclick="location.href='/13_MVC/HomeController?cmd=korean'" />
	<input type="button" value="영문인사요청하기" onclick="location.href='/13_MVC/HomeController?cmd=english'" />

</body>
</html>