package com.koreait.contact1.command;

import java.util.List;

import org.springframework.ui.Model;

import com.koreait.contact1.dao.ContactDao;
import com.koreait.contact1.dto.ContactDto;

public class ContactListCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		
		ContactDao contactDao = new ContactDao();
		List<ContactDto> list = contactDao.contactList();
		model.addAttribute("list", list);

	}

}
