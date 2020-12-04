<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input, select, button {
		width: 30px;
	}
</style>
</head>
<body>

	<%
		String[] operators = {"+", "-", "*", "/"};
	
		String sa = request.getParameter("a");
		String sb = request.getParameter("b");
		int operator = 0;  // 연산의 인덱스
		double a = 0;
		double b = 0;
		double result = 0;
		
		// a와 b가 모두 입력 되었다면
		if (sa != null && !sa.isEmpty() && sb != null && !sb.isEmpty()) {
			a = Double.parseDouble(sa);
			b = Double.parseDouble(sb);
			operator = Integer.parseInt(request.getParameter("operator"));
			switch (operator) {
			case 0: result = a + b; break;
			case 1: result = a - b; break;
			case 2: result = a * b; break;
			case 3: result = a / b; break;
			}
		}
	
	%>

	<h3>계산기</h3>
	<form action="/02_JSP/quiz/Q04.jsp">
		<input type="text" name="a" value="<%=a%>" />
		<select name="operator">
			<% for (int i = 0; i < operators.length; i++) { %>
				<% if (i == operator) { %>
					<option value="<%=i%>" selected><%=operators[i]%></option>
				<% } else { %>
					<option value="<%=i%>"><%=operators[i]%></option>
				<% } %>
			<% } %>
		</select>
		<input type="text" name="b" value="<%=b%>" />
		<button>=</button>
		<input type="text" value="<%=result%>" readonly />
	</form>

</body>
</html>










