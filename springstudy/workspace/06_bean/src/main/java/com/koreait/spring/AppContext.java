package com.koreait.spring;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration : Bean을 생성하는 app-context.xml과 같은 일을 해요.

@Configuration
public class AppContext {
	
	// 메소드가 @Bean 애너테이션을 가지면 Bean을 만들어요.
	// 메소드는 만든 Bean을 반환 처리(return) 해요.
	
	/*
	@Bean
	public 클래스명 객체명() {
		return Bean;
	}
	*/
	
	@Bean
	public Person person2() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("요리");
		hobbies.add("독서");
		hobbies.add("음악감상");
		// 필드를 이용한 생성자
		return new Person("앨리스", hobbies);
	}
	
	
	
}
