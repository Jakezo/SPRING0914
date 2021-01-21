package com.koreait.contact2.command;

import org.springframework.ui.Model;

import com.koreait.contact2.dao.ContactDao;

public class ContactListCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		ContactDao contactDao = new ContactDao();
		model.addAttribute("list", contactDao.contactList());
	}

}
