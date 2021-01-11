package com.koreait.mvc02.dto;

public class ContactDto {

	// field
	private String phone;
	private String address;
	
	// constructor
	public ContactDto() {
	
	}
	public ContactDto(String phone, String address) {
		super();
		this.phone = phone;
		this.address = address;
	}

	// method
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
