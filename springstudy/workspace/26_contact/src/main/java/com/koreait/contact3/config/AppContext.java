package com.koreait.contact3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.koreait.contact3.command.ContactDeleteCommand;
import com.koreait.contact3.command.ContactInsertCommand;
import com.koreait.contact3.command.ContactListCommand;
import com.koreait.contact3.command.ContactUpdateCommand;
import com.koreait.contact3.command.ContactViewCommand;
import com.koreait.contact3.dao.ContactDao;

@Configuration
public class AppContext {

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("spring");
		dataSource.setPassword("1111");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate template() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public ContactDao contactDao() {
		return new ContactDao(template());
	}
	
	@Bean
	public ContactDeleteCommand contactDeleteCommand() {
		return new ContactDeleteCommand();
	}
	
	@Bean
	public ContactInsertCommand contactInsertCommand() {
		return new ContactInsertCommand();
	}
	
	@Bean
	public ContactListCommand contactListCommand() {
		return new ContactListCommand();
	}
	
	@Bean
	public ContactUpdateCommand contactUpdateCommand() {
		return new ContactUpdateCommand();
	}
	
	@Bean
	public ContactViewCommand contactViewCommand() {
		return new ContactViewCommand();
	}
	
}
