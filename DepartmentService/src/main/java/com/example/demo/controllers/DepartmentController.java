package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DepartmentController {
	
	@Autowired
	private RestTemplate template;
	
	@Value("${server.port}")
	private int port;
	
	@GetMapping("/depts")
	@HystrixCommand(fallbackMethod = "fallBackMethod")
	public String getDeptandEmps()
	{
		System.out.println("Hitting the employee Service");
		String resp= template.exchange("http://employee-service/emps",HttpMethod.GET,null,String.class).getBody();
		System.out.println("Got the response ");
		return "Departments in the organisation are ADMIN,HR,IT,FINANCE in port "+port +" "+ resp;
	}
	
	public String fallBackMethod()
	{
		return "The employee Service is not up and running";
	}

}
