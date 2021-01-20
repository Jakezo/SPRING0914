<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script type="text/javascript">

	// 페이지 로드 이벤트
	$(document).ready(function(){
		$('#btn1').click( fn_getText );  // btn1을 클릭하면 fn_getText 함수가 실행됩니다.
	});
	
	// 함수
	function fn_getText() {
		$.ajax({
			url: 'getText',    // @RequestMapping(value="getText")
			type: 'get',       // @RequestMapping(method=RequestMethod.GET)
			dataType: 'text',  // @RequestMapping(produces="text/plain") + 메소드에 @ResponseBody
			success: function(responseText) {
				// responseText는 응답 받은 결과입니다.
				$('#content1').text(responseText.trim());
			},
			error: function() {
				alert('실패');
			}
		});
	}

</script>
<title>Insert title here</title>
</head>
<body>

	<input type="button" value="텍스트가져오기" id="btn1" /><br/>
	<div id="content1"></div>

</body>
</html>

