package com.cts.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.models.ForJson;
import com.cts.service.CollateralRiskService;

@RestController
@RequestMapping("/risk")

public class CollateralLoansRiskAssessmentController {

	@Autowired
	CollateralRiskService collateralRiskService;
	
	@Autowired
	private Proxy proxy;
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value="/getCollateralRisk/{loanId}")
	public String getCollateralRisk(@PathVariable int loanId) throws NumberFormatException, IOException {
//		ForJson result = restTemplate.getForObject("http://Collateral-Management/collateral/getCollaterals/"+loanId,ForJson.class);
		ForJson result = proxy.getriskCollateral(loanId);
		return collateralRiskService.getCollateralRisk(result);	
	}
}
