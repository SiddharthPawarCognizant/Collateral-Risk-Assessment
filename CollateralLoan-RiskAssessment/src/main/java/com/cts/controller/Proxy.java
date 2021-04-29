package com.cts.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.models.ForJson;



@FeignClient(name="Collateral-Management")
public interface Proxy {
	
	 @GetMapping("/collateral/getCollaterals/{loanId}")
		public ForJson getriskCollateral(@PathVariable int loanId);

}
