package com.zohocrmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zohocrmapp.entity.Contact;

import com.zohocrmapp.service.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactServ;
	
	@RequestMapping("/listallcontacts")
	public String listAllLeads(Model model) {
		List<Contact> contact = contactServ.findAllLeads();
		model.addAttribute("contact", contact);
		return  "contact_leads";
	}

}
