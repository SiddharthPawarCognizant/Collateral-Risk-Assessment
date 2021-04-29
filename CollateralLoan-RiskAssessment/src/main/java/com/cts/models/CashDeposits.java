package com.cts.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="CashDeposits")
public class CashDeposits extends CollateralLoan{
	
	private String collateralType;
	private String bankName;
	private double depositAmount;
	private double interestRate;
	private int lockPeriodInMonths;
	
	public CashDeposits(int collateralId, int loanId, int collateralvalue, int sanctionedLoan, String collateralType,
			String bankName, double depositAmount, double interestRate, int lockPeriodInMonths) {
		super(collateralId, loanId, collateralvalue, sanctionedLoan);
		this.collateralType = collateralType;
		this.bankName = bankName;
		this.depositAmount = depositAmount;
		this.interestRate = interestRate;
		this.lockPeriodInMonths = lockPeriodInMonths;
	}
	

	

	
	
	
	
	
}
