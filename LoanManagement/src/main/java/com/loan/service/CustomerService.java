package com.loan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.dao.CustomerRepository;
import com.loan.pojo.Customer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	public Customer GetCustomerDetails(String email) {
		log.info("Inside GetCustomerDetails method of CustomerService");
		return customerRepository.findAllByEmail(email);
	}




	
	
	

}
