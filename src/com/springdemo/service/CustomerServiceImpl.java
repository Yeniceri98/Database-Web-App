package com.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	// Need to inject Customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional		// NOT: Service class'ını oluşturduktan sonra CustomerDAOImpl'dan buraya taşıdık
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

}

/*
	@Service Annotation
	It's applied to Service implementations
	It annotates classes at the service layer
	Spring will automatically register the Service implementation thanks to component-scanning
	NOT: Customer Service oluşturma sebebimiz DAO katmanından önce ara bir katman oluşturmak. CustomerDAO, SalesDAO, ClientDAO gibi birbirinden farklı DAO'lar olabilirdi
	
	Controller ---> Service ---> DAO (Project Overview.PNG de görülebilir)
*/