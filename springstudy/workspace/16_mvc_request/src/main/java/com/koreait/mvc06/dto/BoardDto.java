package com.koreait.mvc06.dto;

import java.sql.Date;

public class BoardDto {

	// field
	private String title;
	private int hit;
	private Date date;
	
	// constructor
	public BoardDto() {
	
	}
	public BoardDto(String title, int hit, Date date) {
		super();
		this.title = title;
		this.hit = hit;
		this.date = date;
	}
	
	// method
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
