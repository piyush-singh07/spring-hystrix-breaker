package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Value("${server.port}")
	int port;
	
	@GetMapping("/emps")
	public String getEmps(){
		return Arrays.asList("Jack","Jones","Kevin","Tom")+" from port "+port;
	}

}
