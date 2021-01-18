<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_usersUpdate(f) {
		if (confirm('수정할까요?')) {
			f.action = 'usersUpdate.do';
			f.submit();
		}
	}
	function fn_usersDelete(f) {
		if (confirm('삭제할까요?')) {
			f.action = 'usersDelete.do';
			f.submit();
		}
	}
</script>
</head>
<body>

	<form method="post">
	
		이름<br/>
		<input type="text" name="name" value="${usersDto.name}" /><br/><br/>
		전화<br/>
		<input type="text" name="phone" value="${usersDto.phone}" /><br/><br/>
		
		<%-- hidden --%>
		<input type="hidden" name="no" value="${usersDto.no}" />
		
		<input type="button" value="수정하기" onclick="fn_usersUpdate(this.form)" />
		<input type="button" value="삭제하기" onclick="fn_usersDelete(this.form)" />
		<input type="button" value="목록보기" onclick="location.href='usersListPage.do'" />
		
	</form>

</body>
</html>