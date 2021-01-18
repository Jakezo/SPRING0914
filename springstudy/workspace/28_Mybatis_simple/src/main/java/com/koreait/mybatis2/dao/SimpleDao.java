package com.koreait.mybatis2.dao;

import java.util.List;

import com.koreait.mybatis2.dto.SimpleDto;

public interface SimpleDao {

	public List<SimpleDto> simpleList();
	
	public int totalCount();
	
	// 삽입 후 성공/실패 처리
	public int simpleInsert(String writer, String title, String content);
	
	public SimpleDto simpleView(int no);
	
	// 수정 후 성공/실패 처리
	public int simpleUpdate(String title, String content, int no);
	
	
	
	
	
}