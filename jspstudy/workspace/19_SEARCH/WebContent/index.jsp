<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script type="text/javascript">
		function fn_title(f) {
			f.action = '/19_SEARCH/searchTitle.white';
			f.submit();
		}
		function fn_content(f) {
			f.action = '/19_SEARCH/searchContent.white';
			f.submit();
		}
		function fn_both(f) {
			f.action = '/19_SEARCH/searchBoth.white';
			f.submit();
		}
	</script>
	<form>
		<h3>WHITE 테이블 검색</h3>
		검색어 <input type="text" name="query" /><br/><br/>
		<input type="button" value="제목검색" onclick="fn_title(this.form)" />
		<input type="button" value="내용검색" onclick="fn_content(this.form)" />
		<input type="button" value="제목+내용검색" onclick="fn_both(this.form)" />
		<input type="button" value="전체목록" onclick="location.href='/19_SEARCH/listPage.white'" />
	</form>

</body>
</html>