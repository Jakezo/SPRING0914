package com.koreait.contact2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.contact2.command.ContactDeleteCommand;
import com.koreait.contact2.command.ContactInsertCommand;
import com.koreait.contact2.command.ContactListCommand;
import com.koreait.contact2.command.ContactUpdateCommand;
import com.koreait.contact2.command.ContactViewCommand;
import com.koreait.contact2.common.SpringJdbc;

@Controller
public class ContactController {

	// field
	private ContactListCommand contactListCommand;
	private ContactViewCommand contactViewCommand;
	private ContactInsertCommand contactInsertCommand;
	private ContactUpdateCommand contactUpdateCommand;
	private ContactDeleteCommand contactDeleteCommand;
	
	@Autowired
	public void setBeans(JdbcTemplate template,
			             ContactListCommand contactListCommand,
			             ContactViewCommand contactViewCommand,
			             ContactInsertCommand contactInsertCommand,
			             ContactUpdateCommand contactUpdateCommand,
			             ContactDeleteCommand contactDeleteCommand) {
		SpringJdbc.template = template;
		this.contactListCommand = contactListCommand;
		this.contactViewCommand = contactViewCommand;
		this.contactInsertCommand = contactInsertCommand;
		this.contactUpdateCommand = contactUpdateCommand;
		this.contactDeleteCommand = contactDeleteCommand;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="contactListPage.do", method=RequestMethod.GET)
	public String list(Model model) {
		contactListCommand.execute(model);
		return "contact/contactListPage";
	}
	
	@RequestMapping(value="contactInsertPage.do", method=RequestMethod.GET)
	public String insertPage() {
		return "contact/contactInsertPage";
	}
	
	@RequestMapping(value="contactInsert.do", method=RequestMethod.POST)
	public String insert(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		contactInsertCommand.execute(model);
		return "redirect:contactListPage.do";
	}
	
	@RequestMapping(value="contactViewPage.do", method=RequestMethod.GET)
	public String viewPage(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		contactViewCommand.execute(model);
		return "contact/contactViewPage";
	}
	
	@RequestMapping(value="contactUpdate.do", method=RequestMethod.POST)
	public String update(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		contactUpdateCommand.execute(model);
		return "redirect:contactViewPage.do?no=" + request.getParameter("no");
	}
	
	@RequestMapping(value="contactDelete.do", method=RequestMethod.POST)
	public String delete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		contactDeleteCommand.execute(model);
		return "redirect:contactListPage.do";
	}
	
}
