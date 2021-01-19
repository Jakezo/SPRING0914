<%@page import="java.net.URLDecoder"%>
<%@page import="com.koreait.mybatis3.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		BoardDto boardDto = (BoardDto)request.getAttribute("boardDto");
		String filename = URLDecoder.decode(boardDto.getFilename(), "utf-8");
		pageContext.setAttribute("filename", filename);
	%>

	<script type="text/javascript">
		function fn_boardDelete(f) {
			if (confirm('삭제할까요?')) {
				f.action = 'boardDelete.do';
				f.submit();
			}
		}
	</script>


	<form method="post">
		
		작성자<br/>
		<input type="text" name="writer" value="${boardDto.writer}" readonly /><br/><br/>
		제목<br/>
		<input type="text" name="title" value="${boardDto.title}"/><br/><br/>
		내용<br/>
		<input type="text" name="content" value="${boardDto.content}"/><br/><br/>
		첨부 이미지 <a href="download.do?filename=${boardDto.filename}">첨부파일 다운로드</a>
		<br/><br/>
		<img alt="${boardDto.filename}" src="resources/storage/${filename}">
		
		<%-- hidden --%>
		<input type="hidden" name="no" value="${boardDto.no}" />
		<input type="hidden" name="filename" value="${boardDto.filename}" />
		
		<input type="button" value="삭제하기" onclick="fn_boardDelete(this.form)" />
		
	</form>

</body>
</html>