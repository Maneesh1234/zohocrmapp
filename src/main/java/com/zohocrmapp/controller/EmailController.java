package com.zohocrmapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.dto.Email;
import com.zohocrmapp.entity.Lead;
import com.zohocrmapp.service.LeadService;
import com.zohocrmapp.util.EmailService;

@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private LeadService leadService;
	@RequestMapping("/sendEmail")
	public String getEmailId(@RequestParam("email") String email,Model model) {
		model.addAttribute("email",email);
		return "compose_email";
	}
	
	
	 
    // Sending a simple Email @ModelAttribute("lead") Lead lead,ModelMap model
    @RequestMapping("/triggerEmail")
    public String sendEmail(@ModelAttribute("email") Email email, ModelMap model)
    {
        String status = emailService.sendEmail(email);
        model.addAttribute("status", status);
        Lead lead=leadService.findLeadByEmail(email.getEmail());
        model.addAttribute("lead", lead);
        return "lead_info";
    }
	
	
	}
