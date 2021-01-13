package com.koreait.simple1.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor  // 필드를 이용한 생성자를 자동으로 생성해 줍니다.
@Data  // lombok의 애너테이션, getter/setter등을 자동으로 생성해 줍니다.
       // Window - Show View - Outline 에서 확인이 가능합니다.
public class SimpleDto {

	// field
	private int no;
	private String writer;
	private String title;
	private String content;
	private Date regDate;
	
}
