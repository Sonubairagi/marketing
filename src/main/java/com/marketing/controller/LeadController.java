package com.marketing.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.DataLead;
import com.marketing.entity.Lead;
import com.marketing.services.LeadService;
import com.marketing.util.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private LeadService leadService;

	//handler methods
	
	//http://localhost:8080/create
	@RequestMapping("/create")
	public String viewCreateLeadPage() {
		return "create_lead";
	}
	
	//Read Data From view
	//1.
	@RequestMapping("/saveLead")
	public String saveOneLead(@ModelAttribute("l")Lead lead, ModelMap model) {
		leadService.saveLeadInfo(lead);
		//emailService.sendEmail(lead.getEmail(), "welcome to psa", "thankyou for join us");
		model.addAttribute("msg", "record get saved");
		return "create_lead";
	}
	
	
	//2.
//	@RequestMapping("/saveLead")
//	public String saveOneLead(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("email") String email,@RequestParam("mobile") String mobile, ModelMap model) {
//		Lead lead = new Lead();
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		
//		leadService.saveLeadInfo(lead);
//		model.addAttribute("msg", "record get saved");
//		return "create_lead";
//	}
	
	
	//3.
//	@RequestMapping("/saveLead")
//	public String saveOneLead(LeadData leadData, ModelMap model) {
//		Lead lead = new Lead();
//		lead.setFirstName(leadData.getFirstName());
//		lead.setLastName(leadData.getLastName());
//		lead.setEmail(leadData.getEmail());
//		lead.setMobile(leadData.getMobile());
//		
//		leadService.saveLeadInfo(lead);
//		model.addAttribute("msg", "record get saved");
//		return "create_lead";
//	}
	

	//http://localhost:8080/listall
	@RequestMapping("/listall")
	public String listAllLeads(Model model) {
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	
	@RequestMapping("/Delete")
	public String deleteOneLead(@RequestParam("id") long id, Model model) {
		leadService.deleteLead(id);
		
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	@RequestMapping("/Update")
	public String updateOneLead(@RequestParam("id") long id, Model model) {
		Lead lead = leadService.getOneLead(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}
	
	@RequestMapping("/updateLead")
	public String updateLead(DataLead lead, Model model) {
		Lead newLead = new Lead();
		newLead.setId(lead.getId());
		newLead.setFirstName(lead.getFirstName());
		newLead.setLastName(lead.getLastName());
		newLead.setEmail(lead.getEmail());
		newLead.setMobile(lead.getMobile());
		
		leadService.saveLeadInfo(newLead);
	   
	   List<Lead> leads = leadService.getLeads();
	   model.addAttribute("leads", leads);
		return "list_leads";
	}
	
}
