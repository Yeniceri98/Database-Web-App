package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/*
	 	NOT: Service class'ını oluşturduktan sonra dependency injection'ını CustomerDAO'ya göre değil CustomerService'e göre yapmalıyız. O yüzden alt kısmı yoruma aldık
	 	NOT: listCustomers() metodunda da getCustomers'ı çekerken DAO üzerinden değil (yoruma aldım) Service üzerinden yaptık
	 	
	 	Controller ---> Service ---> DAO (Project Overview.PNG de görülebilir)
	 	
		Need to inject the CustomerDao
		@Autowired
		private CustomerDAO customerDAO;
	*/
	
	// Need to inject the CustomerService
	@Autowired
	private CustomerService customerService;
	
	// @RequestMapping("/list")   // URL ---> http://localhost:8080/Database_Web_App_-_Spring_and_Hibernate/customer/list
	@GetMapping("/list")		  // NOT: RequestMapping tüm HTTP operasyonlarında çalışır. Eğer sadece spesifik bir operasyonda çalışmak istiyorsak @GetMapping @PostMapping gibi  annotationları kullanılabilir
	public String listCustomers(Model theModel) {		
		
		/*
			// Get customers from the DAO
			List<Customer> theCustomers = customerDAO.getCustomers();
		*/
		
		// Get customers from the Service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// Add the customers to the Model
		theModel.addAttribute("customers", theCustomers);		// Name, Value
		
		return "list-customers";		// list-customers.jsp'yi çalıştırır
	}
}
