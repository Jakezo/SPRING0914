package com.koreait.contact3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.contact3.command.ContactDeleteCommand;
import com.koreait.contact3.command.ContactInsertCommand;
import com.koreait.contact3.command.ContactListCommand;
import com.koreait.contact3.command.ContactUpdateCommand;
import com.koreait.contact3.command.ContactViewCommand;
import com.koreait.contact3.dao.ContactDao;

@Configuration
public class AppContext {

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
	@Bean
	public ContactDao contactDao() {
		return new ContactDao();
	}
	
}
