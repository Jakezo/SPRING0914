package com.koreait.contact3.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.ui.Model;

import com.koreait.contact3.config.AppContext;
import com.koreait.contact3.dao.ContactDao;
import com.koreait.contact3.dto.ContactDto;

public class ContactUpdateCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String note = request.getParameter("note");
		
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		
		contactDao.contactUpdate(new ContactDto(no, name, phone, address, email, note));
		
		ctx.close();

	}

}
