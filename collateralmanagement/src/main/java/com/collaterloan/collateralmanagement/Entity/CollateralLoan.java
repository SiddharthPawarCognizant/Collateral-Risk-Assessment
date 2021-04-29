package com.collaterloan.collateralmanagement.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CollateralLoan")
public class CollateralLoan{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collateralId;
	private int loanId;
	private int collateralvalue;
	private int sanctionedLoan;
//	private Date pledgeDate;
//	@OneToOne(cascade = CascadeType.ALL)
//	private CollateralType collateralType;
//	private String bankName;
//	private double depositAmount;
//	private double interestRate;
//	private int lockPeriodInMonths;
//	private String collateral_address;
//	private double rate_per_sq_ft;
//	private double area;
	
}
