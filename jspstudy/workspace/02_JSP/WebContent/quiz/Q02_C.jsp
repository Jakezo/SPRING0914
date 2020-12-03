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
		request.setCharacterEncoding("UTF-8");
		String age = request.getParameter("age");
	%>
	<%-- 
	<h3>미성년자</h3>
	<div>
		당신의 나이는 <%=age%>살이므로, 주류 구매가 불가능합니다.
	</div>
	
	<br/><br/>
	<a href="/02_JSP/quiz/Q02_A.jsp">처음으로 이동</a>
	--%>
	
	<%-- 다시 뒤로 돌려보내는 방법 --%>
	<script type="text/javascript">
		alert(<%=age%> + '살은 주류 구매가 불가능합니다.');
		history.go(-1);  // 1번 뒤로 이동합니다.
		// 2번 이동이 아닌 이유는 B에서 이동할 때 사용한
		// forward 이동은 이동 카운트에 잡히지 않기 때문입니다. 
	</script>
	
</body>
</html>