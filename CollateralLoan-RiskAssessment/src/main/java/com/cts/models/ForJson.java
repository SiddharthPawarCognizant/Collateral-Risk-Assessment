package com.cts.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ForJson {
	private int loanId;
	private int collateralId;
	private int collateralvalue;
	private int sanctionedLoan;
	private String collateralType;
	private String bankName;
	private double depositAmount;
	private double interestRate;
	private int lockPeriodInMonths;
	private String collateral_address;
	private double rate_per_sq_ft;
	private double area;
}
