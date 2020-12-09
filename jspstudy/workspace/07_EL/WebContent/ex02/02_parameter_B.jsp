<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	${param.a} + ${param.b} = ${param.a + param.b}<br/>
	${param.a} - ${param.b} = ${param.a - param.b}<br/>
	${param.a} * ${param.b} = ${param.a * param.b}<br/>
	
	${param.a} / ${param.b} = ${param.a / param.b}<br/>
	${param.a} / ${param.b} = ${param.a div param.b}<br/>
	
	${param.a} % ${param.b} = ${param.a % param.b}<br/>
	${param.a} % ${param.b} = ${param.a mod param.b}<br/>
	
	<%-- 파라미터는 String타입이므로 크기비교를 사전순으로 한다. --%>
	${param.a} > ${param.b} = ${param.a - param.b gt 0}<br/>
	${param.a} >= ${param.b} = ${param.a - param.b ge 0}<br/>
	${param.a} < ${param.b} = ${param.a - param.b lt 0}<br/>
	${param.a} <= ${param.b} = ${param.a - param.b le 0}<br/>
	${param.a} == ${param.b} = ${param.a eq param.b}<br/>
	${param.a} != ${param.b} = ${param.a ne param.b}<br/>
	
	큰 수: ${param.a - param.b gt 0 ? param.a : param.b}<br/>
	
</body>
</html>