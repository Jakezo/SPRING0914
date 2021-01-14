package com.koreait.simple2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
	이번 SimpleDao는 singleton으로 만들지 않습니다.
	대신 SimpleDao의 생성을 Spring에게 맡기는 DI 방식을 사용하겠습니다.
*/

public class SimpleDao {

	private DataSource dataSource;
	
	public SimpleDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	
	
	
}
