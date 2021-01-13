package com.koreait.simple1.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.simple1.command.SimpleCommand;
import com.koreait.simple1.dao.SimpleDao;

public class SimpleController {

	
	// 21_simple 프로젝트는 command들을 new로 생성하는 연습입니다.
	
	
	// field
	private SimpleCommand command;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="simpleList.do")
	public String simpleList(Model model) {
		// DB에서 list를 가져와서 simpleListPage.jsp로 이동시킵니다.
		// simpleListPage.jsp로 보낼 데이터인 list는 Model에 저장합니다.
		// Model에 저장된 데이터를 simpleListPage.jsp으로 보내려면 forward합니다.
		/*
			SimpleListCommand가 없다면 아래와 같이 작업할 수 있겠습니다.
			하지만, 이렇게 하시면 안 됩니다.
			SimpleDao simpleDao = SimpleDao.getInstance();
			model.addAttribute("list", simpleDao.simpleList());
			return "simple/simpleListPage";
		*/
		
	}
	
	
	
	
	
	
}
