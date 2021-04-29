package com.collaterloan.collateralmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collaterloan.collateralmanagement.Entity.CollateralLoan;
import com.collaterloan.collateralmanagement.Entity.ForJson;
import com.collaterloan.collateralmanagement.repository.CashDepositRepository;
import com.collaterloan.collateralmanagement.repository.RealEstateRepository;
import com.collaterloan.collateralmanagement.service.CollateralLoanService;

@RestController
@RequestMapping("/collateral")
public class CollateralController {
	
	@Autowired
	CollateralLoanService collateralLoanService;
	
	@Autowired
	RealEstateRepository realEstateRepository;
	
	@Autowired
	CashDepositRepository cashDepositRepository;
	
	@GetMapping(value="/hello")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping(value="/getCollaterals/{id}")
	public CollateralLoan getCollatoralDetails(@PathVariable int id) {
		CollateralLoan cl = collateralLoanService.getColateralLoan(id);
		return collateralLoanService.getColateralLoan(id);
	}
	

	
	@PostMapping(value = "/saveCollaterals")
	public String saveCollatoralDetails(@RequestBody ForJson forjson) {
		collateralLoanService.saveColateralDetails(forjson);
		return "Ok";
	}

}
