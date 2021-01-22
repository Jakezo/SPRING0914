<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script type="text/javascript">

	//페이지 로드 이벤트
	$(document).ready(function(){
		if ('${param.authKey}' == 'ok') {
			alert('인증되었습니다.');
			location.href = 'boardListPage.do';			
		}
	});
	
</script>
</head>
<body>

	이메일이 전송되었습니다. 이메일을 확인해 주시길 바랍니다.<br/>
	이메일의 링크를 클릭하면 계속해서 서비스를 이용할 수 있습니다.

</body>
</html>