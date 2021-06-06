package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	private Logger log = Logger.getLogger(EmployeeController.class);
	
	@Value("${server.port}")
	int port;
	
	@GetMapping("/emps")
	public String getEmps(){
		log.info("inside employee controller");
		return Arrays.asList("Jack","Jones","Kevin","Tom")+" from port "+port;
	}

}
