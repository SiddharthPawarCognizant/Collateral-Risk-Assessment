package com.cts.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.RestTemplate;

import com.cts.models.CashDeposits;
import com.cts.models.CollateralLoan;
import com.cts.models.CollateralRisk;
import com.cts.models.ForJson;
import com.cts.models.Real_Estate;
import com.cts.repository.CollateralRiskRepository;

@Service
public class CollateralRiskService {

	@Autowired
	CollateralRiskRepository collateralRiskRepository;

	@Autowired
	ResourceLoader resourceLoader;
	
	public String getCollateralRisk(ForJson forjson) throws NumberFormatException, IOException{
		
		double current_value=0.0;
		if(forjson.getCollateralType().equalsIgnoreCase("Realestate")) {
			Real_Estate real_Estate = new Real_Estate(forjson.getCollateralId(), forjson.getLoanId(),
					forjson.getCollateralvalue(),forjson.getSanctionedLoan(),forjson.getCollateralType(),
					forjson.getCollateral_address(), forjson.getRate_per_sq_ft(), forjson.getArea());
				current_value = real_Estate.getArea()*currentValueRealEstate();
				if(current_value<real_Estate.getSanctionedLoan()) {
					return "yeh to vijay mallya banega";
				}
				else {
					return "ok";
				}
			  
			
			
		}else {
			CashDeposits cashdeposit = new CashDeposits(forjson.getCollateralId(), forjson.getLoanId(),
					forjson.getCollateralvalue(),forjson.getSanctionedLoan(),forjson.getCollateralType(), forjson.getBankName(),
					forjson.getDepositAmount(), forjson.getInterestRate(), forjson.getLockPeriodInMonths());
			
					current_value = currentValueCashDeposit();
					if(current_value<cashdeposit.getCollateralvalue()) {
						return "yeh to vijay mallya banega";
					}
					else{
						return "ok";
					}
		}
		

		
	}
	
	private double currentValueCashDeposit() throws IOException {
		org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:marketvalueCashDeposit.txt");
	    InputStream inputStream = resource.getInputStream();
	 
	    try
	    {
	        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
	        String data = new String(bdata, StandardCharsets.UTF_8);
	        String substr = data.substring(12);
	        return Double.parseDouble(substr);
	    } 
	    catch (IOException e) 
	    {
	    }
	return 0.0;
	}

	public double currentValueRealEstate() throws IOException {
		
		 	org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:marketvalueRealEstate.txt");
		    InputStream inputStream = resource.getInputStream();
		 
		    try
		    {
		        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
		        String data = new String(bdata, StandardCharsets.UTF_8);
		        String substr = data.substring(17);
		        return Double.parseDouble(substr);
		    } 
		    catch (IOException e) 
		    {
		    }
		return 0.0;
        
	}

}