<%@page import="dao.RedDao"%>
<%@page import="dto.RedDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	// 1. 파라미터 처리
	request.setCharacterEncoding("UTF-8");
	int no = Integer.parseInt(request.getParameter("no"));
	
	// 2. DAO
	RedDto redDto = RedDao.getInstance().view(no);
	
	// 3. EL 사용을 위해서
	pageContext.setAttribute("redDto", redDto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${redDto eq null}">
		<script type="text/javascript">
			alert('회원 정보가 없습니다. 다시 확인하세요.');
			history.back();
		</script>
	</c:if>
	
	<c:if test="${redDto ne null}">
		${redDto.name}님의 정보입니다.
	</c:if>

</body>
</html>




