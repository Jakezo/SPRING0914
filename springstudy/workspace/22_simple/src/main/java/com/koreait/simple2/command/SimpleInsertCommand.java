package com.koreait.simple2.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.simple2.dao.SimpleDao;
import com.koreait.simple2.dto.SimpleDto;

public class SimpleInsertCommand implements SimpleCommand {

	// field
	@Autowired
	private SimpleDao simpleDao;
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");  // model에 저장된 속성(attribute)을 키 값으로 사용하면 됩니다.
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		SimpleDto simpleDto = new SimpleDto();
		simpleDto.setWriter(writer);
		simpleDto.setTitle(title);
		simpleDto.setContent(content);
		
		simpleDao.simpleInsert(simpleDto);

	}

}
