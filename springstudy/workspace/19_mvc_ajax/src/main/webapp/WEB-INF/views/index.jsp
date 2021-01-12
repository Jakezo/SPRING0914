<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%-- jquery CDN --%>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

<script type="text/javascript">
	
	// 페이지 로드 이벤트
	$(function(){
		fn_send1();
	});
	
	function fn_send1() {
		$('#btn1').click(function(){
			$.ajax({
				url: 'getText',  // RequestMapping의 value를 작성합니다.
				type: 'get',  // RequestMapping의 method를 작성합니다.
				data: 'send=' + $('#send').val(),  // controller로 보내는 값(파라미터)
				dataType: 'text',  // controller에게서 받아 오는 값의 타입
				success: function(responseText) {  // responseText: controller에게서 받아 오는 값
					$('#content1').text(responseText.trim());  // trim(): 불필요한 공백 제거
				},
				error: function(){
					alert('실패');
				}
			});
		});
	}
	
</script>


<title>Insert title here</title>
</head>
<body>

	<form>
	
		보내는 값<br/>
		<input type="text" id="send" name="send" /><br/><br/>
		
		<input type="button" id="btn1" value="일반텍스트" /><br/>
		<div id="content1"></div>
	
	</form>

</body>
</html>



