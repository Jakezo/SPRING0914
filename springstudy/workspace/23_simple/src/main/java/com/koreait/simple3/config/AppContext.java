package com.koreait.simple3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.simple3.command.SimpleDeleteCommand;
import com.koreait.simple3.command.SimpleInsertCommand;
import com.koreait.simple3.command.SimpleListCommand;
import com.koreait.simple3.command.SimpleUpdateCommand;
import com.koreait.simple3.command.SimpleViewCommand;
import com.koreait.simple3.dao.SimpleDao;

/*
	@Configuration
	: 안녕. 난 root-context.xml 처럼 Bean을 만드는 자바 클래스야.
*/

@Configuration
public class AppContext {

	/*
		@Bean
		: 안녕. 난 Bean이야.
	*/
	/*
		반환타입: SimpleListCommand -> <Bean class="SimpleListCommand">
		메소드명: listCommand -> <Bean id="listCommand">
	*/
	@Bean
	public SimpleListCommand listCommand() {
		return new SimpleListCommand();
	}
	
	@Bean
	public SimpleViewCommand viewCommand() {
		return new SimpleViewCommand();
	}
	
	@Bean
	public SimpleInsertCommand insertCommand() {
		return new SimpleInsertCommand();
	}
	
	@Bean
	public SimpleUpdateCommand updateCommand() {
		return new SimpleUpdateCommand();
	}
	
	@Bean
	public SimpleDeleteCommand deleteCommand() {
		return new SimpleDeleteCommand();
	}
	
	@Bean
	public SimpleDao simpleDao() {
		return new SimpleDao();
	}
	
	
	
	
}
