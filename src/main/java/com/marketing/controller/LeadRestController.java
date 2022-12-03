package com.marketing.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entity.Lead;
import com.marketing.repositories.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepo;

	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
	
	@PostMapping
	public void savaOneStudent(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	
	@PutMapping
	public void updateOneStudent(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	
	// http://localhost:8080/api/leads/delete/id
	@DeleteMapping("/delete/{id}")
	public void deleteOneStudent(@PathVariable("id") long id) {
		leadRepo.deleteById(id);
	}
	
	// http://localhost:8080/api/leads/LeadInfo/1
	@RequestMapping("LeadInfo/{id}")
	public Lead leadInfo(@PathVariable("id") long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}
}
