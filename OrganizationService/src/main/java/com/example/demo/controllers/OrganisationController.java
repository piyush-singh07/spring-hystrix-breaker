package com.example.demo.controllers;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
public class OrganisationController {
	
	private Logger log = Logger.getLogger(OrganisationController.class);
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping("/orgs")
	public String getorgan()
	{
		log.info("inside organsation service");
		String res= template.exchange("http://department-service/depts", HttpMethod.GET,null, String.class).getBody();
		return "Organisation :" + res;
	}

}
