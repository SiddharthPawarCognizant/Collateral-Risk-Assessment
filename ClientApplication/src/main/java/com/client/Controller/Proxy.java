package com.client.Controller;



import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.client.pojo.CustomerLoan;
import com.client.pojo.ForJson;

//@FeignClient(name="API-GATEWAY")
public interface Proxy {
	
	@PostMapping("/loan/saveCollaterals")
	public String SaveCollateralValues(ForJson forj);
	
	@GetMapping("/loan/getLoanDetails/{customerid}/{loanid}")
	public List<CustomerLoan> getloan(@PathVariable("customerid") int customerid,@PathVariable("loanid") int loanid);
	
	@GetMapping("/risk/getCollateralRisk/{loanId}")
	public String getRisk(@PathVariable("loanId") int loanId);

}
