package com.zohocrmapp.service;

import java.util.List;

import com.zohocrmapp.entity.Contact;


public interface ContactService {

	public void saveContact(Contact contact);

      public List<Contact> findAllContact();

	public Contact getContactByID(long id);

	public List<Contact> findAllLeads();

	

	
}
