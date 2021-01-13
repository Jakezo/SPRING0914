<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>계산기</h3>
	<form name="f">
		<input type="text" id="one" /><br>
		<input type="text" id="two" /><br>
		<div id="result"></div>
		<input type="button" value="더하기" id="btn1"/>
	</form>
	
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		
		function checkEmpty(){
			
			if($('#one').val() != ''&& $('#two').val() != ''){
				return true;
			}else{
				alert('값을 입력하시오.');
				return false;
			}
			
		}
	
		$('#btn1').click(function(){
			
			var type = $('#btn1').val();
			var one = $('#one').val();
			var two = $('#two').val();
			
			if(type == '초기화면'){
				document.forms.f.reset();
				$('#btn1').val('더하기');
				$('#result').empty();
				return;
			}
			
			if(checkEmpty()){
			
				if(type == '더하기'){
					
					$.ajax({
						url: 'sum',
						type: 'get',
						data: 'one=' + one + '&two=' + two,
						dataType: 'json',
						success:function(responseObj){
							var result = responseObj.one + '+' + responseObj.two + '=' + responseObj.result;
							$('#result').text(result);
							$('#btn1').val('빼기');
						}
					});
				}
			
				
				if(type == '빼기'){
					
					$.ajax({
						url: 'subtraction',
						type: 'get',
						data: 'one=' + one + '&two=' + two,
						dataType: 'json',
						success:function(responseObj){
							var result = responseObj.one + '-' + responseObj.two + '=' + responseObj.result;
							$('#result').text(result);
							$('#btn1').val('곱하기');
						}
					});
				}
			
				
				if(type == '곱하기'){
					
					$.ajax({
						url: 'multyply',
						type: 'get',
						data: 'one=' + one + '&two=' + two,
						dataType: 'json',
						success:function(responseObj){
							var result = responseObj.one + 'x' + responseObj.two + '=' + responseObj.result;
							$('#result').text(result);
							$('#btn1').val('나누기');
						}
					});
				}
			
			
				
				if(type == '나누기'){
					
					$.ajax({
						url: 'divide',
						type: 'get',
						data: 'one=' + one + '&two=' + two,
						dataType: 'json',
						success:function(responseObj){
							var result = responseObj.one + '/' + responseObj.two + '=' + responseObj.result;
							$('#result').text(result);
							$('#btn1').val('초기화면');
						}
					});
				}
				
			}
			
			
		});
	
	</script>	
</body>
</html>