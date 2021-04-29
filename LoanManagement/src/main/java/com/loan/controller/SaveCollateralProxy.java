package com.loan.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.loan.pojo.ForJson;

@FeignClient(name="Collateral-Management")
public interface SaveCollateralProxy {
	
	
     @PostMapping("/collateral/saveCollaterals")
	public String SaveCollateral(@RequestBody ForJson collateralDetails);

}
