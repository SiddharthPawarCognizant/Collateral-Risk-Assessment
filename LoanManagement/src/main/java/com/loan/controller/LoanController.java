package com.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan.pojo.Customer;
import com.loan.pojo.CustomerLoan;
import com.loan.pojo.ForJson;
import com.loan.service.CustomerLoanService;
import com.loan.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/loan")
@Slf4j
public class LoanController {

	@Autowired
	private CustomerService customerService;
	

	@Autowired
	private SaveCollateralProxy saveCollateralProxy;

	
	@Autowired
	CustomerLoanService customerLoanService;
	

	
	@GetMapping("/getCustomer/{email}")
	public List<CustomerLoan> getCustomerLoanForCustomer(@PathVariable("email") String email) {
		log.info("Inside getCustomerLoanForCustomer method of loanController");
		Customer cus= customerService.GetCustomerDetails(email);
		List<CustomerLoan> customerLoan1=customerLoanService.getcustomerdatils(cus.getCustomerId());
		return customerLoan1;

	}

	@GetMapping("/getLoanDetails/{customerid}/{loanid}")
	public List<CustomerLoan> GetLoanDetails(@PathVariable("customerid") int customerid,@PathVariable("loanid") int LoanId) {
		log.info("Inside getloan method of loanController");
		List<CustomerLoan> customerLoan=customerLoanService.GetLoanDetails(customerid,LoanId);
		 return customerLoan;
	}

	
	@PostMapping("/saveCollaterals")
	public String CollateralDetails( @RequestBody ForJson collateralDetails) {
		log.info("Inside CollateralDetails method of loanController");
		String result=saveCollateralProxy.SaveCollateral(collateralDetails);
		return result;
	}
	


}
