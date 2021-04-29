package com.loan;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.loan.controller.LoanController;
import com.loan.pojo.Customer;
import com.loan.pojo.CustomerLoan;

@SpringBootTest
class LoanManagementApplicationTests {
     
	@Autowired
	LoanController LoanController;
	
	
	
	@Test
	void testGetCustomerLoanForCustomer() {
		List<CustomerLoan> actual = LoanController.getCustomerLoanForCustomer("siddharth@gmail.com");
		
		Customer customer1=new Customer();
		customer1.setCustomerId(1);
		customer1.setEmail("siddharth@gmail.com");
		customer1.setFirstName("Siddharth");
		customer1.setLastName("Pawar");	
		
		CustomerLoan cl1=new CustomerLoan();
		cl1.setCustomerLoanId(1);
//		cl1.setCollateralId(2);
		cl1.setLoanId(1);
		cl1.setEmi(500);
		cl1.setInterest(6.5);
		cl1.setCustomer(customer1);
		cl1.setLoanPricipal(5000);
		cl1.setTenure(3);

		
		CustomerLoan CustomerLoan2=new CustomerLoan();
		CustomerLoan2.setCustomerLoanId(2);
//		CustomerLoan2.setCollateralId(1);
		CustomerLoan2.setLoanId(2);
		CustomerLoan2.setEmi(1000);
		CustomerLoan2.setInterest(5.5);
		CustomerLoan2.setCustomer(customer1);
		CustomerLoan2.setLoanPricipal(7000);
		CustomerLoan2.setTenure(2);
	
		
     assertEquals(actual.size(), 2);
     assertEquals(actual.get(0).getCustomerLoanId(),cl1.getCustomerLoanId());
     assertEquals(actual.get(1).getEmi(),CustomerLoan2.getEmi());

	}
	
	@Test
	void testGetLoanDetails() {
		List<CustomerLoan> actual = LoanController.GetLoanDetails(1,1);
		    assertEquals(actual.get(0).getLoanPricipal(),5000);
		    assertEquals(actual.get(0).getLoanId(),1);

	}
	

}
