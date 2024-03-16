package com.zohocrmapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zohocrmapp.dto.Email;


@Service
public class EmailServiceImpl implements EmailService {
	
//	@Autowired
//	private JavaMailSender javaMailSender;
//
//	@Override
//	public void sendEmail(String to, String sub, String emailBody) {
//		SimpleMailMessage s=new SimpleMailMessage();
//		s.setTo(to);
//		s.setSubject(sub);
//		s.setText(emailBody);
//		javaMailSender.send(s);
//		
//	
//	}
	
	@Autowired private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}") private String sender;

	// Method 1
	// To send a simple email
	public String sendEmail(Email details)
	{

		// Try block to check for exceptions
		try {

			// Creating a simple mail message
			SimpleMailMessage mailMessage
				= new SimpleMailMessage();

			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getEmail());
			mailMessage.setText(details.getContent());
			mailMessage.setSubject(details.getSubject());

			// Sending the mail
			javaMailSender.send(mailMessage);
			return "Mail Sent Successfully...";
		}

		// Catch block to handle the exceptions
		catch (Exception e) {
			return "Error while Sending Mail";
		}
	}

}
