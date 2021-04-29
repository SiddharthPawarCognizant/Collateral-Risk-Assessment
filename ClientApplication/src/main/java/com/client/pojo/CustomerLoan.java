package com.client.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoan {
	

	private int customerLoanId;
	

	private int loanId;
	

//	private int collateralId;
	
	private long loanPricipal;
	
	private float tenure; 
	
	private double interest;

	private double emi;
	


	private Customer customer;
	
	

	
	

}
