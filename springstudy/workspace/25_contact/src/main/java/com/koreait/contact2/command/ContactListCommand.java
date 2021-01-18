package com.koreait.contact2.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.contact2.dao.ContactDao;

public class ContactListCommand implements ContactCommand {

	private ContactDao contactDao;
	
	@Autowired
	public ContactListCommand(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	
	@Override
	public void execute(Model model) {
		model.addAttribute("list", contactDao.contactList());
	}

}
