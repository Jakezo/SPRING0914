<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		주의사항.
		a 태그의 매핑값은 아래와 같이 슬래시(/)로 시작하면 안 됩니다. 
		<a href="/member/loginPage.do">
	--%>

	<a href="member/loginPage.do">로그인하러 가기</a><br/><br/>
	
	<%--
		주의사항.
		location.href의 매핑값은 아래와 같이 슬래시(/)로 시작하면 안 됩니다. 
		location.href='/member/loginPage.do'
	--%>
	
	<input type="button" value="로그인하러 가기" onclick="location.href='member/loginPage.do'" />

</body>
</html>