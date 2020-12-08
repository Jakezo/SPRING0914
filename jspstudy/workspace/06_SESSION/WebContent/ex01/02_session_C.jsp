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
		String data = "데이터 없음";
		if ( session.getAttribute("data") != null ) {
			data = (String)session.getAttribute("data");
		}
	%>
	
	<h3>세션의 data: <%=data%></h3>
	
	
	
	

</body>
</html>