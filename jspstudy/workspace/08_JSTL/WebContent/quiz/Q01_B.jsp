<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 문제1 --%>
	<%--
	<c:if test="${age >= 0 and age <= 7}">
		미취학아동
	</c:if>
	<c:if test="${age >= 8 and age <= 13}">
		초등학생
	</c:if>
	<c:if test="${age >= 14 and age <= 16}">
		중학생
	</c:if>
	<c:if test="${age >= 17 and age <= 19}">
		고등학생
	</c:if>
	<c:if test="${age >= 20}">
		성인
	</c:if>
	--%>
	
	<%-- 문제2. --%>
	<c:if test="${param.n >= 0}">
		<c:set var="abs" value="${param.n}" />
	</c:if>
	<c:if test="${param.n < 0}">
		<c:set var="abs" value="${param.n * -1}" />
	</c:if>
	
	${param.n}의 절대값은 ${abs}입니다.
	
</body>
</html>













