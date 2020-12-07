<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {
		padding: 0px;
		margin: 0px;
	}
	a {
		text-decoration: none;
		color: black;
	}
	ul, ol {
		list-style-type: none;
	}
	table {
		border-collapse: collapse;
	}
	div {
		box-sizing: border-box;
	}
	.head-wrap {
		height: 300px;
		background: skyblue;
		position: relative;  /* 자식요소들이 position: absolute; 가능해진다. */
	}
	.head-wrap > ul {
		position: absolute;  /* 부모요소 중 position: relative;인 요소 기준으로 top, bottom, left, right 사용이 가능해진다. */
		bottom: 0px;  /* 바닥에 붙인다. */
		left: 0px;    /* 왼쪽에 붙인다. */
		overflow: hidden;  /* 자식요소 li태그에 float: left;를 주면 자식요소들이 수평레이아웃이 된다. */
		height: 30px;
	}
	.head-wrap > ul > li {
		float: left;
		width: 50px;
		height: 100%;
	}
	.wrap {
		width: 800px;
		margin: auto;
	}
	.main-wrap {
		width: 100%;
		height: 500px;
		padding-top: 30px;
	}
	.main-wrap > .login-box {
		width: 400px;
		margin: auto;
		text-align: center;
	}
	.main-wrap > .login-box > input {
		width: 100%;
		padding: 5px;
	}
	.foot-wrap {
		text-align: center;
		background: skyblue;
	}
	
</style>
</head>
<body>
	<div class="head-wrap">
		<ul>
			<li>홈</li>
			<li>방명록</li>
			<li>게시판</li>
			<li>리뷰</li>
			<li>Q&A</li>
		</ul>
	</div>
	<div class="wrap">
		<div class="main-wrap">
			<div class="login-box">
				<input type="text" name="id" placeholder="아이디" /><br/>
				<input type="password" name="pw" placeholder="****" /><br/><br/>
				<button>로그인</button>
			</div>
		</div>
		<div class="foot-wrap">
			<a href="javascript:void(0)">기업체정보</a> / 
			<a href="javascript:void(0)">저작권</a> / 
			<a href="javascript:void(0)">약관</a> 
		</div>
	</div>
</body>
</html>