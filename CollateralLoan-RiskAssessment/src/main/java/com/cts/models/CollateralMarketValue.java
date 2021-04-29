package com.cts.models;

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
@Table(name = "CollateralMarketValue")
public class CollateralMarketValue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int market_value_id;
	private double market_value;
	private double rate_of_interest;
}