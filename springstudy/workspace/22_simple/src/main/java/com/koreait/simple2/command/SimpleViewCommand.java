package com.koreait.simple2.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.simple2.dao.SimpleDao;
import com.koreait.simple2.dto.SimpleDto;

public class SimpleViewCommand implements SimpleCommand {

	// field
	@Autowired
	private SimpleDao simpleDao;
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		SimpleDto simpleDto = simpleDao.simpleView(no);
		
		model.addAttribute("simpleDto", simpleDto);

	}

}
