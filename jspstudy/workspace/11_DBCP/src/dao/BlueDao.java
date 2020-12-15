package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BlueDao {

	// 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	// 그 동안 사용하던 DriverManager 클래스를 사용하지 않기 때문에
	// getConnection() 메소드를 만들어서 사용하지 않는다.
	
	// DBCP 방식은 Connection을 DataSource 클래스가 관리한다.
	// 앞으로는 DataSource 객체가 제공하는 getConnection() 메소드를 사용한다.
	
	// DataSource 객체 만들기 (새로운 작업)
	private static DataSource dataSource;
	// static { }  // static 블록에서 static 필드의 초기화를 할 수 있다.
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			// Tomcat의 경우 java:comp/env/ 를 prefix로 사용한다.
			// context.xml의 <Resource>태그의 name속성이 jdbc/oracle이다.
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 메소드
	/***** 1. 접속 종료 *****/
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) { rs.close(); }
			if (ps != null) { ps.close(); }
			if (con != null) { con.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***** 2. 접속 테스트 *****/
	public void test() {
		try {
			con = dataSource.getConnection();
			System.out.println("접속성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, null, null);
		}
	}
	
	
	
	
	
	
	
	
}
