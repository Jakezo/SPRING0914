<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>view02.jsp</h3>
	
	<%-- ModelAndView의 addObject()를 통해서 attribute로 전달되는 데이터는 request에 있어요. --%>
	<ul>
		<li>이름: ${name}</li>
		<li>나이: ${age}</li>
	</ul>

</body>
</html>