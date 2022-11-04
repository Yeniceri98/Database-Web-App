package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// Need to inject the CustomerDao
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")			// URL ---> http://localhost:8080/Database_Web_App_-_Spring_and_Hibernate/customer/list
	public String listCustomers(Model theModel) {		
		
		// Get customers from the DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		// Add the customers to the model
		theModel.addAttribute("customers", theCustomers);		// Name, Value
		
		return "list-customers";		// list-customers.jsp'yi çalıştırır
	}
}
