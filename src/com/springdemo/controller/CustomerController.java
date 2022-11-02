package com.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@RequestMapping("/list")		// URL ---> http://localhost:8080/Database_Web_App_-_Spring_and_Hibernate/customer/list
	public String listCustomers(Model theModel) {		
		return "list-customers";		// list-customers.jsp'yi çalıştırır
	}
}
