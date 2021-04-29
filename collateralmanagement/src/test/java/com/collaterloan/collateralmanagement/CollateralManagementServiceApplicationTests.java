package com.collaterloan.collateralmanagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.collaterloan.collateralmanagement.Entity.CollateralLoan;
import com.collaterloan.collateralmanagement.Entity.ForJson;
import com.collaterloan.collateralmanagement.Entity.Real_Estate;
import com.collaterloan.collateralmanagement.controller.CollateralController;

@SpringBootTest
class CollateralManagementServiceApplicationTests {
	
	@Autowired
	CollateralController cdc;

	@Test
	void testGetCollateralDetails() {
//		CollateralController cdc = new CollateralController();
		CollateralLoan CollateralLoan=new Real_Estate(1, 1, 50000,30000,"RealEstate","Mumbai", 20, 2500);
		
		CollateralLoan actualcollatoralDetails = cdc.getCollatoralDetails(1);
		Assertions.assertEquals(CollateralLoan,actualcollatoralDetails);
	}
	
	@Test
	void saveGetCollateralDetails() {
//		CollateralController cdc = new CollateralController();
		ForJson forjson = new ForJson(1000, 1200, 50000, 30000, "RealEstate", null, 0, 0, 0, "Mumbai", 5, 8);
		String result = cdc.saveCollatoralDetails(forjson);
//		CollateralLoan getCollateralLoan = cdc.getCollatoralDetails(1000);
		Assertions.assertEquals("Ok",result);
//		Assertions.assertEquals(forjson,getCollateralLoan);
	}
	
	

}
