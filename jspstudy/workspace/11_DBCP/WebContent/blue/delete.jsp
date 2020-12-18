<%@page import="java.io.File"%>
<%@page import="dao.BlueDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String strNo = request.getParameter("no");
	int no = 0;
	if ( strNo != null && !strNo.isEmpty() ) {
		no = Integer.parseInt(strNo);
	}
	
	int result = BlueDao.getInstance().delete(no);
	
	/***** 파일삭제하는 부분 *****/
	if (result > 0) {
		String realPath = request.getParameter("realPath");
		String filename = request.getParameter("filename");
		File file = new File(realPath, filename);
		if (file.exists()) {
			file.delete();
		}
	}
	/****************************/
	
%>
<script>
	var result = <%=result%>;
	if (result > 0) {
		alert('삭제되었습니다.');
		location.href='/11_DBCP/blue/listPage.jsp';
	} else {
		alert('삭제되지 않았습니다.');
		history.back();
	}
</script>
