package com.koreait.simple1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.koreait.simple1.dto.SimpleDto;

public class SimpleDao {

	// Connection Pool 처리는 DataSource 클래스가 합니다.
	// 필요한 설정은 톰캣 내부의 context.xml에 있습니다.
	// <Resource name="jdbc/oracle">을 처리하는 Context 클래스가 필요합니다.
	// name에 의한 접근: JNDI
	
	private DataSource dataSource;
	
	// singleton
	private SimpleDao() {
		// context.xml에 있는 설정을 읽어와서 dataSource를 만듭니다.
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");  // 톰캣이다: java:comp/env/ 나머지는 <Resource>의 name 속성
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static SimpleDao simpleDao = new SimpleDao();
	public static SimpleDao getInstance() {
		return simpleDao;
	}
	
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	
	private void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) { rs.close(); }
			if (ps != null) { ps.close(); }
			if (con != null) { con.close(); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/***** 1. list *****/
	public List<SimpleDto> simpleList() {
		
		List<SimpleDto> list = new ArrayList<SimpleDto>();
		
		try {
			con = dataSource.getConnection();
			sql = "SELECT NO, WRITER, TITLE, CONTENT, REGDATE FROM SIMPLE";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();  // select문 실행 메소드
			while (rs.next()) {
				int no = rs.getInt("NO");
				String writer = rs.getString("WRITER");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Date regDate = rs.getDate("REGDATE");
				SimpleDto simpleDto = new SimpleDto(no, writer, title, content, regDate);
				list.add(simpleDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		
		return list;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}