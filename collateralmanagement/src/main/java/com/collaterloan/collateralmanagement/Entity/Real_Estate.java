package com.collaterloan.collateralmanagement.Entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="RealEstate")
public class Real_Estate extends CollateralLoan{
	private String collateralType;
	private String collateral_address;
	private double rate_per_sq_ft;
	private double area;
	
	public Real_Estate(int collateralId, int loanId, int collateralvalue, int sanctionedLoan, String collateralType,
			String collateral_address, double rate_per_sq_ft, double area) {
		super(collateralId, loanId, collateralvalue, sanctionedLoan);
		this.collateralType = collateralType;
		this.collateral_address = collateral_address;
		this.rate_per_sq_ft = rate_per_sq_ft;
		this.area = area;
	}


	
	
	
}
