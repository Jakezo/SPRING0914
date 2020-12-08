<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
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
		ArrayList<Map> cart = (ArrayList<Map>)session.getAttribute("cart");
		
		String result = "";
		if (cart == null) {
			result = "장바구니가 비었습니다.";
		} else {
			for (Map<String, String> map : cart) {
				for (Map.Entry<String, String> entry : map.entrySet()) {
					String product = entry.getKey();
					String quantity = entry.getValue();
					result += product + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + quantity + "개<br/>";
				}
			}
		}
	%>

	<h3>장바구니 리스트</h3>
	<%=result%>
	<br/><br/>
	<input type="button" value="계속쇼핑하기" 
	       onclick="location.href='/06_SESSION/ex03/01_cart_B.jsp'" />
	<input type="button" value="장바구니비우기"
	       onclick="location.href='/06_SESSION/ex03/01_cart_E.jsp'" />

</body>
</html>




