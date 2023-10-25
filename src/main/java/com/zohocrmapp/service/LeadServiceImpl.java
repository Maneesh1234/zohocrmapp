package com.zohocrmapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrmapp.entity.Lead;
import com.zohocrmapp.repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {
   @Autowired
	private LeadRepository leadRepo;
	@Override
	public void saveOneLead(Lead lead) {
		
		leadRepo.save(lead);
	}
	@Override
	public Lead findLeadById(long id) {
		Optional<Lead> lead = leadRepo.findById(id);
		Lead lead2 = lead.get();
		return lead2;
	}
	@Override
	public void deleteLeadById(long id) {
		leadRepo.deleteById(id);
		
	}
	@Override
	public List<Lead> findAllLeads() {
		List<Lead> lead = leadRepo.findAll();
		return lead;
	}

}
