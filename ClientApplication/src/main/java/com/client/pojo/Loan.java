package com.client.pojo;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan  {
	
	private int loanId;
	
	private String loanProducts;
	
	private long maxLoan;
	
	private double interest;
	
	private float tenure;
	
	private String typeCollateralAccepted;
	
	
    private Set<CustomerLoan> customerLoan;
	

	
	

}
