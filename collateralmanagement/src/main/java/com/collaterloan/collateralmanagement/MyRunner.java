package com.collaterloan.collateralmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.collaterloan.collateralmanagement.Entity.ForJson;
import com.collaterloan.collateralmanagement.service.CollateralLoanService;

@Component
public class MyRunner implements CommandLineRunner {
	
	@Autowired
	CollateralLoanService collateralLoanService;
	

	
	@Override
	public void run(String... args) throws Exception {
		ForJson forjson = new ForJson(1, 1, 50000,30000,"RealEstate", "null", 0, 0, 0, "Mumbai", 20, 2500);
		collateralLoanService.saveColateralDetails(forjson);
		ForJson forjson2 = new ForJson(2, 2, 50000,40000,"CashDeposit", "null", 40000, 6, 24, "null", 0, 0);
		collateralLoanService.saveColateralDetails(forjson2);
		
	}

}
