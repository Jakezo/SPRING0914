<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/style/red.css" />
<style type="text/css">
	td:nth-of-type(1) {
		width: 150px;
	}
	td:nth-of-type(2) {
		text-align: left;
	}
	input[type=password] {
		padding: 5px;
		width: 400px;
	}
</style>
<script type="text/javascript">

	function fn_pwChange(f) {
		// 1. 회원의 현재 비밀번호(변경 이전 비밀번호)
		var prev_pw = '${param.pw}';
		if (prev_pw != f.prev_pw.value) {
			alert('올바른 비밀번호를 입력하세요.');
			f.prev_pw.focus();
			return;
		}
		// 2. 신규 비밀번호 확인
		var pw = f.pw.value;  	// 신규 비밀번호
		var pw2 = f.pw2.value;	// 비밀번호 확인
		if (pw == '' || pw != pw2 || prev_pw == pw) {
			alert('비밀번호를 확인하세요.');
			return;
		}
		f.action = '/10_DAO/red/pwChange.jsp';
		f.submit();
	}
	
</script>
</head>
<body>

	<div class="wrap">
		<form method="post">
			<table>
				<tbody>
					<tr>
						<td>현재 비밀번호</td>
						<td><input type="password" name="prev_pw" /></td>
					</tr>
					<tr>
						<td>신규 비밀번호</td>
						<td><input type="password" name="pw" /></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" name="pw2" /></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" value="비밀번호변경하기" onclick="fn_pwChange(this.form)" />
							<input type="button" value="취소하기" onclick="alert('취소되었습니다.'); history.back()" />
						</td>
					</tr>
				</tfoot>
			</table>
			<%-- 비밀번호변경 이동시 넘겨 줄 파라미터 --%>
			<input type="hidden" name="no" value="${param.no}" />
		</form>
	</div>

</body>
</html>