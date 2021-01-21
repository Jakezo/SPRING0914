<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script type="text/javascript">

	/*
		REST : URI + HTTP Method
		
				URI				Method
		목록	member			GET
		보기	member/{no}		GET
		삽입	member			POST
		수정	member			PUT
		삭제	member/{no}		DELETE
	*/

	// 페이지 로드 이벤트
	$(document).ready(function(){
		memberList();
		memberView();
		memberInsert();
		memberUpdate();
		memberDelete();
		init();
	});
	
	/***** 1. 회원 목록 *****/
	function memberList() {
		// URI : member, Method : GET
		$.ajax({
			url: 'member',
			type: 'get',
			dataType: 'json',
			success: function(responseList) {
				/*
					responseList = {
						"list": [
							{
								"no": 1,
								"id": "user1",
								"name": "제임스",
								"gender": "남",
								"address": "서울"
							},
							...
						],
						"result": true
					}
				*/
				if (responseList.result == true) {
					memberListTable(responseList.list);  // 서브 함수 호출
				}
			},
			error: function(){
				alert('실패');
			}
		});
	}
	// 서브 함수: 회원 목록을 테이블로 만들어 주는 함수
	function memberListTable(list) {
		$('#memberList').empty();  // 기존 목록을 제거합니다.
		$.each(list, function(idx, member){
			$('<tr>')
			.append( $('<td>').html(member.no) )
			.append( $('<td>').html(member.id) )
			.append( $('<td>').html(member.name) )
			.append( $('<td>').html(member.gender) )
			.append( $('<td>').html(member.address) )
			.append( $('<td>').html('<input type="button" value="조회" id="btnView" />'))
			.append( $('<td>').html('<input type="button" value="삭제" id="btnDelete" />'))
			.appendTo('#memberList');
		});
	}
	
	/***** 2. 회원 정보 *****/
	function memberView() {
		
	}
	
	/***** 3. 회원 삽입 *****/
	function memberInsert() {
		
		// URI : member, Method : POST
		// 입력데이터 -> JSON 데이터로 만듭니다.
		// 만들어진 JSON 데이터를 컨트롤러로 넘겨줍니다.
		// POST 방식은 파라미터를 본문(body)에 실어 줍니다. (JSON 데이터를 body에 실어 줍니다.)
		// 그래서 컨트롤러는 요청 파라미터(request)를 본문에서 꺼내야 합니다. -> @RequestBody 애너테이션이 필요하다는 의미입니다.
		
		$('#btnInsert').click(function(){
			var id = $('input:text[name="id"]').val();
			var name = $('input:text[name="name"]').val();
			var gender = $('input:radio[name="gender"]:checked').val();
			var address = $('select[name="address"]').val();
			var sendObj = {
					"id": id,
					"name": name,
					"gender": gender,
					"address": address
				};
			$.ajax({
				url: 'member',
				type: 'post',
				data: JSON.stringify(sendObj),  // 컨트롤러로 보내는 JSON 데이터(신규회원정보)
				contentType: 'application/json',  // 컨트롤러로 보내는 데이터의 타입
				dataType: 'json',
				success: function(responseObj) {
					/*
						responseObj = {
							"result": 1 (성공)
							또는
							"result": 0 (실패)
						}
					*/
					if (responseObj.result == 1) {
						alert('신규 회원이 등록되었습니다.');
						memberList();  // 새로 회원 목록을 출력합니다.
					} else {
						alert('신규 회원 등록에 실패했습니다.');
					}
				},
				error: function(){
					alert('실패');
				}
			});
			
		});
		
	}
	
	/***** 4. 회원 수정 *****/
	function memberUpdate() {
		
	}
	
	/***** 5. 회원 삭제 *****/
	function memberDelete() {
		
	}
	
	/***** 6. 초기화 *****/
	function init() {
		$('#btnInit').click(function(){
			$('input:text[name="id"]').val('');
			$('input:text[name="name"]').val('');
			$('input:radio[name="gender"]').prop('checked', false);
			$('select[name="address"]').val('');
			memberList();
		});
	}
	
</script>
<title>Insert title here</title>
<style type="text/css">
	.wrap {
		display: flex;
	}
	.left {
		width: 500px;
	}
	.right {
		width: 1000px;
	}
	table {
		border-collapse: collapse;
	}
	td, th {
		border-top: 1px solid black;
		border-bottom: 1px solid black;
		padding: 5px 20px;
		text-align: center;
	}
	th {
		background: silver;
	}
</style>
</head>
<body>
	
	<div class="wrap">
		
		<div class="left">
			<!-- 등록/수정/보기 페이지 -->
			<h3>회원 등록/수정/보기</h3>
			아이디<br/>
			<input type="text" name="id" /><br/><br/>
			이름<br/>
			<input type="text" name="name" /><br/><br/>
			성별<br/>
			<input type="radio" name="gender" value="남" />남
			<input type="radio" name="gender" value="여" />여<br/><br/>
			주소<br/>
			<select name="address">
				<option value="">지역 선택</option>
				<option value="서울">서울</option>
				<option value="인천">인천</option>
				<option value="부산">부산</option>
				<option value="제주">제주</option>
				<option value="강원">강원</option>
			</select><br/><br/>
			<input type="button" value="등록" id="btnInsert" />
			<input type="button" value="수정" id="btnUpdate" />
			<input type="button" value="초기화" id="btnInit" />
		</div>
		
		<div class="right">
			<!-- 목록/삭제 페이지 -->
			<h3>회원 목록</h3>
			<table>
				<thead>
					<tr>
						<th>회원번호</th>
						<th>아이디</th>
						<th>이름</th>
						<th>성별</th>
						<th>주소</th>
						<th colspan="2">비고</th>
					</tr>
				</thead>
				<tbody id="memberList"></tbody>
			</table>
		</div>
		
	</div>
	
</body>
</html>