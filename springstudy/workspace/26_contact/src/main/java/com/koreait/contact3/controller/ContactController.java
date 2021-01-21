package com.koreait.contact3.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.contact3.command.ContactDeleteCommand;
import com.koreait.contact3.command.ContactInsertCommand;
import com.koreait.contact3.command.ContactListCommand;
import com.koreait.contact3.command.ContactUpdateCommand;
import com.koreait.contact3.command.ContactViewCommand;
import com.koreait.contact3.common.SpringJdbc;
import com.koreait.contact3.config.AppContext;

@Controller
public class ContactController {

	// field
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		SpringJdbc.template = this.template;
	}
	
	private AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="contactInsertPage.do", method=RequestMethod.GET)
	public String insertPage() {
		return "contact/contactInsertPage";
	}

	@RequestMapping(value="contactListPage.do", method=RequestMethod.GET)
	public String list(Model model) {
		ContactListCommand contactListCommand = ctx.getBean("contactListCommand", ContactListCommand.class);
		contactListCommand.execute(model);
		return "contact/contactListPage";
	}
	
	@RequestMapping(value="contactInsert.do", method=RequestMethod.POST)
	public String insert(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		ContactInsertCommand contactInsertCommand = ctx.getBean("contactInsertCommand", ContactInsertCommand.class);
		contactInsertCommand.execute(model);
		return "redirect:contactListPage.do";
	}
	
	@RequestMapping(value="contactViewPage.do", method=RequestMethod.GET)
	public String viewPage(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		ContactViewCommand contactViewCommand = ctx.getBean("contactViewCommand", ContactViewCommand.class);
		contactViewCommand.execute(model);
		return "contact/contactViewPage";
	}
	
	@RequestMapping(value="contactUpdate.do", method=RequestMethod.POST)
	public String update(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		ContactUpdateCommand contactUpdateCommand = ctx.getBean("contactUpdateCommand", ContactUpdateCommand.class);
		contactUpdateCommand.execute(model);
		return "redirect:contactViewPage.do?no=" + request.getParameter("no");
	}
	
	@RequestMapping(value="contactDelete.do", method=RequestMethod.POST)
	public String delete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		ContactDeleteCommand contactDeleteCommand = ctx.getBean("contactDeleteCommand", ContactDeleteCommand.class);
		contactDeleteCommand.execute(model);
		return "redirect:contactListPage.do";
	}
	
}
