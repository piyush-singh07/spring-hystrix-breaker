package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrganisationController {
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping("/orgs")
	public String getorgan()
	{
		String res= template.exchange("http://department-service/depts", HttpMethod.GET,null, String.class).getBody();
		return "Organisation :" + res;
	}

}
