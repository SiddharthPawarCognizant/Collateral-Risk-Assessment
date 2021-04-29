package com.loan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.dao.CustomerLoanRepository;
import com.loan.pojo.CustomerLoan;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerLoanService {
	
	@Autowired
	CustomerLoanRepository customerLoanRepository;
	
	public List<CustomerLoan> GetLoanDetails(int customerid, int LoanId) {
		log.info("Inside GetLoanDetails method of CustomerLoanService");
		return customerLoanRepository.findByCustomerIdAndLoanId(customerid,LoanId);
	}

	

	public List<CustomerLoan> getcustomerdatils(int customerId) {
		log.info("Inside getcustomerdatils method of CustomerLoanService");
		return customerLoanRepository.findAllByCustomerId(customerId);
	}
	
	

}
