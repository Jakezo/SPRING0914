package com.koreait.contact2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactDto {

	private int no;
	private String name;
	private String phone;
	private String address;
	private String email;
	private String note;
	
}
