package com.koreait.mvc06.dto;

public class PersonDto {

	// field
	private String name;
	private String age;
	
	// constructor
	public PersonDto() {
		
	}
	public PersonDto(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	// method
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
