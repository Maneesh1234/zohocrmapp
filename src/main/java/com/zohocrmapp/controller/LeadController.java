package com.zohocrmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.entity.Contact;
import com.zohocrmapp.entity.Lead;
import com.zohocrmapp.service.ContactService;
import com.zohocrmapp.service.LeadService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadServ;
	@Autowired
	private ContactService contactServ;
	@RequestMapping("/viewCreateLead")
	public String createViewLead() {
		return "create_new_lead";
	}
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute("lead") Lead lead,ModelMap model) {
	       leadServ.saveOneLead(lead);
	       model.addAttribute("msg", "Record created");
		return "lead_info";
	}
	@RequestMapping("/convertLead")
  public String convertLead(@RequestParam("id") long id,Model model) {
		Lead lead=leadServ.findLeadById(id);
		
		Contact contact=new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		contactServ.saveContact(contact);
		
		leadServ.deleteLeadById(id);
		List<Contact> contacts = contactServ.findAllLeads();
		model.addAttribute("contact", contacts);
		return  "contact_leads";
		
	}
	@RequestMapping("/listall")
	public String listAllLeads(Model model) {
		List<Lead> leads = leadServ.findAllLeads();
		model.addAttribute("leads", leads);
		return  "lead_leads";
	}
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id") long id,Model model) {
		 Lead lead = leadServ.findLeadById(id);
		 model.addAttribute("lead", lead);
		 return "lead_info";
	}
}
