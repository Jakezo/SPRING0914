package com.koreait.contact2.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreait.contact2.dao.ContactDao;
import com.koreait.contact2.dto.ContactDto;

public class ContactInsertCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String note = request.getParameter("note");
		
		ContactDto contactDto = new ContactDto();
		contactDto.setName(name);
		contactDto.setPhone(phone);
		contactDto.setAddress(address);
		contactDto.setEmail(email);
		contactDto.setNote(note);
		
		ContactDao contactDao = new ContactDao();
		contactDao.contactInsert(contactDto);

	}

}
