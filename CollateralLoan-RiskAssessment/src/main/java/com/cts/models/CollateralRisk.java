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
@Table(name = "CollateralRisk")
public class CollateralRisk {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collateral_risk_id;
	private String collateral_risk_details;
	private int percentage_risk;

}
