package com.koreait.contact1.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.contact1.command.ContactCommand;
import com.koreait.contact1.command.ContactInsertCommand;
import com.koreait.contact1.command.ContactListCommand;
import com.koreait.contact1.command.ContactViewCommand;
import com.koreait.contact1.common.SpringJdbc;

@Controller
public class ContactController {

	@Autowired
	public void setTemplate(JdbcTemplate template) {  // @Autowired로 injection된 매개변수 JdbcTemplate template를
		SpringJdbc.template = template;  // 다른 곳(dao)에서 사용할 수 있도록 넘겨 줍니다.
	}
	
	// ContactCommand 인터페이스 선언해 둡니다.
	private ContactCommand command;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="contactListPage.do", method=RequestMethod.GET)
	public String list(Model model) {
		command = new ContactListCommand();
		command.execute(model);
		return "contact/contactListPage";
	}
	
	@RequestMapping(value="contactInsertPage.do", method=RequestMethod.GET)
	public String insertPage() {
		return "contact/contactInsertPage";
	}
	
	@RequestMapping(value="contactInsert.do", method=RequestMethod.POST)
	public String insert(HttpServletRequest request, Model model) {
		// request : contactInsertPage.jsp에서 전달된 5개 파라미터
		// model : ContactInsertCommand에 전달하는 파라미터
		model.addAttribute("request", request);
		command = new ContactInsertCommand();
		command.execute(model);
		return "redirect:contactListPage.do";
	}
	
	@RequestMapping(value="contactViewPage.do", method=RequestMethod.GET)
	public String viewPage(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new ContactViewCommand();
		command.execute(model);
		return "contact/contactViewPage";
	}
	
	
	
	
	
	
	
	
	
}
