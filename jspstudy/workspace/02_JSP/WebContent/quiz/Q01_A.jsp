<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		사이트명:
		<select name="site">
			<option value="https://www.google.com">구글</option>
			<option value="https://www.naver.com">네이버</option>
			<option value="https://www.daum.net">다음</option>
			<option value="https://www.nate.com">네이트</option>
		</select>
		<input type="button" value="확인" onclick="fn_goToSite(this.form)" />
	</form>
	<script type="text/javascript">
		function fn_goToSite(f) {
			f.action = '/02_JSP/quiz/Q01_B.jsp';
			f.submit();
		}
	</script>
	
	<br/><br/>
	<%
		String[][] sites = {
			{"https://www.google.com", "구글"},
			{"https://www.naver.com", "네이버"},
			{"https://www.daum.net", "다음"},
			{"https://www.kakao.com", "카카오"}
		};
	%>
	<select name="portal">
		<% for (int i = 0; i < sites.length; i++) { %>
			<option value="<%=sites[i][0]%>"><%=sites[i][1]%></option>
		<% } %>
	</select>
	
</body>
</html>