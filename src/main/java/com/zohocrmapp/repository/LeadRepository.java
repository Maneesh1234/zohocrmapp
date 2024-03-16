package com.zohocrmapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zohocrmapp.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {
	@Query(nativeQuery = true,  value = "SELECT leads.id, leads.email, leads.first_name, leads.last_name, leads.mobile, leads.source\r\n"
			+ "FROM zohocrmapp.leads where email=:email")
	public Lead findByEmail(@Param("email") String email);

	
}
