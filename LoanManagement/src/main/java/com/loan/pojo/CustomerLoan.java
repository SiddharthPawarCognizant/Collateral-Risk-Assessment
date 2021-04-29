package com.loan.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class CustomerLoan {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerLoanId;
	
	@Column
	private int loanId;
	
	@Column
	private long loanPricipal;
	@Column
	private float tenure; 
	@Column
	private double interest;
	@Column
	private double emi;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;


	
	
	

	
	

}
