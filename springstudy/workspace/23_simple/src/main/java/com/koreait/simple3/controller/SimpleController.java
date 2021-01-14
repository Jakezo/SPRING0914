package com.koreait.simple3.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.simple3.dto.SimpleDto;
import com.koreait.simple3.command.SimpleDeleteCommand;
import com.koreait.simple3.command.SimpleInsertCommand;
import com.koreait.simple3.command.SimpleListCommand;
import com.koreait.simple3.command.SimpleUpdateCommand;
import com.koreait.simple3.command.SimpleViewCommand;
import com.koreait.simple3.config.AppContext;

@Controller
public class SimpleController {

	
	/*
		Java(AppContext.java)로 Bean을 만들 때
		1. Controller는 AnnotationConfigApplicationContext ctx를 필드로 선언해 둡니다.
		2. 모든 command는 ctx.getBean()으로 필요하면 Bean을 가져와서 사용합니다.
		3. com.springsource.net.sf.cglib-2.1.3.jar 라이브러리를 추가해 줍니다.
		   1) tomcat/lib 폴더에 추가할 수 있고,
		   2) 아니면 Maven Dependencies 에 추가해서 해당 프로젝트에서만 사용할 수 있습니다.
	*/
	
	
	// field
	private AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
	
	
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="simpleListPage.do")
	public String simpleListPage(Model model) {
		SimpleListCommand simpleListCommand = ctx.getBean("listCommand", SimpleListCommand.class);
		// SimpleListCommand simpleListCommand = (SimpleListCommand)ctx.getBean("listCommand");
		simpleListCommand.execute(model);
		return "simple/simpleListPage";
	}
	
	
	@RequestMapping(value="simpleInsertPage.do")
	public String simpleInsertPage() {
		return "simple/simpleInsertPage";
	}
	
	
	@RequestMapping(value="simpleInsert.do")
	public String simpleInsert(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		SimpleInsertCommand simpleInsertCommand = ctx.getBean("insertCommand", SimpleInsertCommand.class);
		simpleInsertCommand.execute(model);
		return "redirect:simpleListPage.do";
	}
	
	
	@RequestMapping(value="simpleViewPage.do")
	public String simpleViewPage(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		SimpleViewCommand simpleViewCommand = ctx.getBean("viewCommand", SimpleViewCommand.class);
		simpleViewCommand.execute(model);
		return "simple/simpleViewPage";
	}
	
	
	@RequestMapping(value="simpleUpdatePage.do", method=RequestMethod.POST)
	public String simpleUpdatePage(SimpleDto simpleDto, Model model) {
		model.addAttribute("simpleDto", simpleDto);
		return "simple/simpleUpdatePage";
	}
	
	
	@RequestMapping(value="simpleUpdate.do", method=RequestMethod.POST)
	public String simpleUpdate(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		SimpleUpdateCommand simpleUpdateCommand = ctx.getBean("updateCommand", SimpleUpdateCommand.class);
		simpleUpdateCommand.execute(model);
		return "redirect:simpleViewPage.do?no=" + request.getParameter("no");
	}
	
	
	@RequestMapping(value="simpleDelete.do", method=RequestMethod.POST)
	public String simpleDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		SimpleDeleteCommand simpleDeleteCommand = ctx.getBean("deleteCommand", SimpleDeleteCommand.class);
		simpleDeleteCommand.execute(model);
		return "redirect:simpleListPage.do";
	}
	
	
}
