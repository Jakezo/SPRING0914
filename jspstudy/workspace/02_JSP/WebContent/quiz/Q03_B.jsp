<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String entertainer = request.getParameter("entertainer");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<h3>2. 좋아하는 운동선수는 누구입니까?</h3>
		<input type="text" name="player" />
		<input type="hidden" name="name" value="<%=name%>" />
		<input type="hidden" name="entertainer" value="<%=entertainer%>" />
		<input type="button" value="결과보기" onclick="fn_go(this.form)" />
	</form>
	<script type="text/javascript">
		function fn_go(f) {
			f.action = '/02_JSP/quiz/Q03_C.jsp';
			f.submit();
		}
	</script>
</body>
</html>