package com.collaterloan.collateralmanagement.service;

import org.springframework.stereotype.Service;

import com.collaterloan.collateralmanagement.Entity.CashDeposits;
import com.collaterloan.collateralmanagement.repository.CashDepositRepository;

@Service
public class CashDepositService {
	
	CashDepositRepository cashDepositRepository;
	
	public CashDeposits getCashDeposits(int id) {
		return cashDepositRepository.findById(id).get();
	}
	
}
