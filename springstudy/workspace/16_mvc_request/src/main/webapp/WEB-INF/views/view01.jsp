<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>view01.jsp</h3>
	
	<%-- request에 포함된 파라미터(Controller로 전달한 값) --%>
	<ul>
		<li>${param.name}</li>
		<li>${param.age}</li>
	</ul>
	
	<%-- model이 저장한 속성(Controller에서 전달된 값) --%>
	<ul>
		<li>${name2}</li>
		<li>${age2}</li>
	</ul>

</body>
</html>