package com.koreait.contact1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.koreait.contact1.common.SpringJdbc;
import com.koreait.contact1.dto.ContactDto;

public class ContactDao {

	// DBCP을 직접 사용할 때는
	// 연결, PreparedStatement 생성, 쿼리문 생성, 변수 처리, 실행, 반복, 연결 종료 등 모든 작업을
	// 반복적으로 개발자가 수행합니다.
	
	// 이 중 몇몇 작업(연결, PreparedStatement 생성 등)을 JdbcTemplate template이 처리합니다.
	
	// 톰캣의 context.xml을 사용하지 않기 때문에
	// context.lookup("java:comp/env/jdbc/oracle")를 호출할 필요가 없습니다.
	
	// common 패키지의 SpringJdbc.template을 불러와서 사용하면 됩니다.
	
	/*
		예전에 parameter들을 해킹하려는 시도가 있었습니다.
		그래서 스프링에서는 매개변수를 final 처리를 요구할 수 있습니다.
		
		이렇게 전달되지 않는다면,
		public ContactDto contactView1(int no) {
			sql = "SELECT * FROM CONTACT WHERE NO = " + no;
			ContactDto contactDto = template.queryForObject(sql, new BeanPropertyRowMapper<ContactDto>(ContactDto.class));
			return contactDto;
		}
		
		이렇게 전달하면 됩니다.
		public ContactDto contactView1(final int no) {
			sql = "SELECT * FROM CONTACT WHERE NO = " + no;
			ContactDto contactDto = template.queryForObject(sql, new BeanPropertyRowMapper<ContactDto>(ContactDto.class));
			return contactDto;
		}
	*/
	
	// field
	private JdbcTemplate template;
	
	public ContactDao() {
		this.template = SpringJdbc.template;
	}
	
	// 공통 필드는 이제 String sql 뿐입니다.
	private String sql;
	
	
	/***** 1. list *****/
	public List<ContactDto> contactList() {
		sql = "SELECT * FROM CONTACT";
		List<ContactDto> list = template.query(sql, new BeanPropertyRowMapper<ContactDto>(ContactDto.class));
		return list;
	}
	
	/***** 2-1. view *****/
	public ContactDto contactView1(final int no) {
		sql = "SELECT * FROM CONTACT WHERE NO = " + no;
		ContactDto contactDto = template.queryForObject(sql, new BeanPropertyRowMapper<ContactDto>(ContactDto.class));
		return contactDto;
	}
	/***** 2-2. view *****/
	public ContactDto contactView2(int no) {
		sql = "SELECT * FROM CONTACT WHERE NO = ?";
		ContactDto contactDto = template.queryForObject(sql, new BeanPropertyRowMapper<ContactDto>(ContactDto.class), no);
		return contactDto;
	}
	
	
	// INSERT, UPDATE, DELETE문은 모두 template.update()를 사용합니다.

	
	/***** 3-1. insert *****/
	public void contactInsert1(ContactDto contactDto) {
		sql = "INSERT INTO CONTACT VALUES (CONTACT_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, contactDto.getName());
				ps.setString(2, contactDto.getPhone());
				ps.setString(3, contactDto.getAddress());
				ps.setString(4, contactDto.getEmail());
				ps.setString(5, contactDto.getNote());
			}
		});
	}
	/***** 3-2. insert *****/
	public void contactInsert2(String name, String phone, String address, String email, String note) {
		sql = "INSERT INTO CONTACT VALUES (CONTACT_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, name);
				ps.setString(2, phone);
				ps.setString(3, address);
				ps.setString(4, email);
				ps.setString(5, note);
			}
		});
	}
	/***** 3-3. insert *****/
	public void contactInsert3(ContactDto contactDto) {
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				sql = "INSERT INTO CONTACT VALUES (CONTACT_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, contactDto.getName());
				ps.setString(2, contactDto.getPhone());
				ps.setString(3, contactDto.getAddress());
				ps.setString(4, contactDto.getEmail());
				ps.setString(5, contactDto.getNote());
				return ps;
			}
		});
	}
	
	/***** 4. update *****/
	public void contactUpdate(ContactDto contactDto) {
		sql = "UPDATE CONTACT SET NAME = ?, PHONE = ?, ADDRESS = ?, EMAIL = ?, NOTE = ? WHERE NO = ?";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, contactDto.getName());
				ps.setString(2, contactDto.getPhone());
				ps.setString(3, contactDto.getAddress());
				ps.setString(4, contactDto.getEmail());
				ps.setString(5, contactDto.getNote());
				ps.setInt(6, contactDto.getNo());
			}
		});
	}
	
	/***** 5. delete *****/
	public void contactDelete(int no) {
		sql = "DELETE FROM CONTACT WHERE NO = ?";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, no);
			}
		});
	}
	
}
