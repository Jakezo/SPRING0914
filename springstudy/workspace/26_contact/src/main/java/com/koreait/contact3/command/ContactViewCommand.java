package com.koreait.contact3.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.ui.Model;

import com.koreait.contact3.config.AppContext;
import com.koreait.contact3.dao.ContactDao;

public class ContactViewCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int no = Integer.parseInt(request.getParameter("no"));

		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		
		model.addAttribute("contactDto", contactDao.contactView(no));
		
		ctx.close();
		
	}

}