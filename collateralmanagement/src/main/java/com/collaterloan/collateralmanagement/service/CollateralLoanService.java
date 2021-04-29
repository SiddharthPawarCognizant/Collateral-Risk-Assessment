package com.collaterloan.collateralmanagement.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaterloan.collateralmanagement.Entity.CashDeposits;
import com.collaterloan.collateralmanagement.Entity.CollateralLoan;
import com.collaterloan.collateralmanagement.Entity.CollateralType;
import com.collaterloan.collateralmanagement.Entity.ForJson;
import com.collaterloan.collateralmanagement.Entity.Real_Estate;
import com.collaterloan.collateralmanagement.repository.CashDepositRepository;
import com.collaterloan.collateralmanagement.repository.ColateralLoanRepository;
import com.collaterloan.collateralmanagement.repository.RealEstateRepository;

@Service
public class CollateralLoanService {

	@Autowired
	ColateralLoanRepository colateralLoanRepository;

	@Autowired
	RealEstateRepository realEstateRepository;

	@Autowired
	CashDepositRepository cashDepositRepository;

	public CollateralLoan getColateralLoan(int id) {
		return colateralLoanRepository.findById(id).get();
	}

	public void saveColateralDetails(ForJson forjson) {

		if (forjson.getCollateralType().equalsIgnoreCase("RealEstate")) {
			Real_Estate re = new Real_Estate(forjson.getCollateralId(), forjson.getLoanId(),
					forjson.getCollateralvalue(),forjson.getSanctionedLoan(),forjson.getCollateralType(),
					forjson.getCollateral_address(), forjson.getRate_per_sq_ft(), forjson.getArea());
			colateralLoanRepository.save(re);
		} else {
			CashDeposits cd = new CashDeposits(forjson.getCollateralId(), forjson.getLoanId(),
					forjson.getCollateralvalue(),forjson.getSanctionedLoan(),forjson.getCollateralType(), forjson.getBankName(),
					forjson.getDepositAmount(), forjson.getInterestRate(), forjson.getLockPeriodInMonths());
			colateralLoanRepository.save(cd);
		}
	}

}
