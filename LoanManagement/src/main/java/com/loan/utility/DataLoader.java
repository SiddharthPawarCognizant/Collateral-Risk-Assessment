package com.loan.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.loan.dao.CustomerLoanRepository;
import com.loan.dao.CustomerRepository;
import com.loan.pojo.Customer;
import com.loan.pojo.CustomerLoan;

@Component
public class DataLoader implements ApplicationRunner{
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerLoanRepository customerLoanRepository;
	
	public void run(ApplicationArguments args) {
		Customer customer1=new Customer();
		customer1.setCustomerId(1);
		customer1.setEmail("siddharth@gmail.com");
		customer1.setFirstName("Siddharth");
		customer1.setLastName("Pawar");	
		customerRepository.save(customer1);
		
		Customer customer2=new Customer();
		customer2.setCustomerId(2);
		customer2.setEmail("Shubham@gmail.com");
		customer2.setFirstName("Shubham");
		customer2.setLastName("Khole");	
		customerRepository.save(customer2);
		
		
		CustomerLoan cl1=new CustomerLoan();
		cl1.setCustomerLoanId(1);
		cl1.setLoanId(1);
		cl1.setEmi(500);
		cl1.setInterest(6.5);
		cl1.setCustomer(customer1);
		cl1.setLoanPricipal(5000);
		cl1.setTenure(3);
		customerLoanRepository.save(cl1);
		

		CustomerLoan CustomerLoan2=new CustomerLoan();
		CustomerLoan2.setCustomerLoanId(2);
		CustomerLoan2.setLoanId(2);
		CustomerLoan2.setEmi(1000);
		CustomerLoan2.setInterest(5.5);
		CustomerLoan2.setCustomer(customer1);
		CustomerLoan2.setLoanPricipal(7000);
		CustomerLoan2.setTenure(2);
		customerLoanRepository.save(CustomerLoan2);
		
		
		CustomerLoan CustomerLoan3=new CustomerLoan();
		CustomerLoan3.setCustomerLoanId(3);
		CustomerLoan3.setLoanId(3);
		CustomerLoan3.setEmi(2000);
		CustomerLoan3.setInterest(6);
		CustomerLoan3.setCustomer(customer2);
		CustomerLoan3.setLoanPricipal(4000);
		CustomerLoan3.setTenure(1);
		customerLoanRepository.save(CustomerLoan3);
		
		
		
		
		
		
		

		
		
	}
}
