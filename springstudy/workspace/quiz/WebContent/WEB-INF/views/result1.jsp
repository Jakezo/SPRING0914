<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="calc">
	
		첫 번째 수: ${n1 }<br>
		두 번째 수: ${n2 }<br>
		${result }
		<input type="hidden" name="n1" value="${n1 }"/>
		<input type="hidden" name="n2" value="${n2 }"/>
		<input type="hidden" name="iter" value="${iter }"/>
		<button>${btn }</button>
	</form>
	
</body>
</html>