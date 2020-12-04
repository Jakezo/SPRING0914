<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 나는 에러페이지입니다. --%>
<%@ page isErrorPage="true" %>

<script>
	alert('결과는 정수만 허용됩니다. 다시 시도하세요.');
	history.back();
</script>