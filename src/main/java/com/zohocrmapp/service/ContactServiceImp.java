package com.zohocrmapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrmapp.entity.Contact;
import com.zohocrmapp.entity.Lead;
import com.zohocrmapp.repository.ContactRepository;
@Service
public class ContactServiceImp implements ContactService {
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public void saveContact(Contact contact) {
		contactRepo.save(contact);
		
	}

	@Override
	public List<Contact> findAllContact() {
		List<Contact> contact = contactRepo.findAll();
		return contact;
	}

	@Override
	public Contact getContactByID(long id) {
		Optional<Contact> find = contactRepo.findById(id);
		 Contact contact = find.get();
		return contact;
	}

	@Override
	public List<Contact> findAllLeads() {
		List<Contact> leads = contactRepo.findAll();
		return leads;
	}



}