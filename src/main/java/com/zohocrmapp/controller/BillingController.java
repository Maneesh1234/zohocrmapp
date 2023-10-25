package com.zohocrmapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.dto.Billing;
import com.zohocrmapp.entity.Contact;
import com.zohocrmapp.service.ContactService;

@Controller
public class BillingController {
	 @Autowired
	 private ContactService contactService;
	 
	@RequestMapping("/generateBill")
	public String viewBillPage(@RequestParam("id") long id,ModelMap model) { 
		
	Contact	contact=contactService.getContactByID(id);
	model.addAttribute("contact", contact);
	return "generate_bill1";

   }

}
