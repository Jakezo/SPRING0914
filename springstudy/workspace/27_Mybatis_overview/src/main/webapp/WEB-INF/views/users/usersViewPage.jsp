<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post">
		이름<br/>
		<input type="text" name="name" value="${usersDto.name}" /><br/><br/>
		전화<br/>
		<input type="text" name="phone" value="${usersDto.phone}" /><br/><br/>
		<input type="button" value="수정하기" onclick="fn_usersUpdate(this.form)" />
		<input type="button" value="삭제하기" onclick="fn_usersDelete(this.form)" />
		<input type="button" value="목록보기" onclick="location.href='usersListPage.do'" />
	</form>

</body>
</html>