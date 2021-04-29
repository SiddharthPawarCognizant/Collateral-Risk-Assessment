package com.client.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.client.pojo.CustomerLoan;
import com.client.pojo.ForJson;
import com.client.pojo.LoginRequest;
import com.client.pojo.LoginResponse;

@Controller
public class ClientController {

	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired
//	private Proxy proxy;
	
	@RequestMapping(value = "/login")
	public String Login() {
		return "login";
	}
	
	@RequestMapping(value = "/logout")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String LoginPost(HttpSession session, @RequestParam String name,
			@RequestParam String password) {
		
		LoginRequest LR=new LoginRequest();
		LR.setUsername(name);
		LR.setPassword(password);
		
		ResponseEntity<LoginResponse> postForEntity = restTemplate.postForEntity("http://localhost:9191/authentication-service/authenticate", LR, LoginResponse.class);
		LoginResponse body = postForEntity.getBody();
		session.setAttribute("token", body.getToken());
		
	
		return "redirect:firstpage";
	}
	
	
	

	
	@RequestMapping(value = "/firstpage")
	public String EnterEmail(ModelMap model) {
		return "EnterEmail";
	}
	
	@RequestMapping(value = "/firstpage", method = RequestMethod.POST)
	public String EnterEmailPost(HttpSession session,ModelMap model, @RequestParam String email) {
		String token=(String) session.getAttribute("token");
         HttpHeaders header=new HttpHeaders();
         String JWT="Bearer "+token;
         header.add("Authorization",JWT);
         HttpEntity<String> entity=new  HttpEntity<String>(header);
         
     	HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("email", email);
		
         ResponseEntity<CustomerLoan[]> exchange = restTemplate.exchange("http://localhost:9191/loan/loan/getCustomer/{email}",HttpMethod.GET,entity,CustomerLoan[].class,uriVariables);
         System.out.println(exchange);
//		ResponseEntity<CustomerLoan[]> forEntity = restTemplate.getForEntity(
//				"http://localhost:9191/loan/getCustomer/{email}", CustomerLoan[].class, email);
//		CustomerLoan[] result = forEntity.getBody();
         CustomerLoan[] result = exchange.getBody();
		model.put("result", result);
		return "Customer";
	}
	
	
	
	
//	@RequestMapping(value = "/page")
//	public String EnterValues(ModelMap model) {
//		return "EnterDetails";
//	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String EnterValuesPost(HttpSession session,ModelMap model, @RequestParam int customerid, @RequestParam int loanid) {
		String token=(String) session.getAttribute("token");
        HttpHeaders header=new HttpHeaders();
        String JWT="Bearer "+token;
        header.add("Authorization",JWT);
        HttpEntity<String> entity=new  HttpEntity<String>(header);
        
        HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("customerid", customerid);
		uriVariables.put("loanid", loanid);

		
        ResponseEntity<CustomerLoan[]> exchange = restTemplate.exchange("http://localhost:9191/loan/loan/getLoanDetails/{customerid}/{loanid}",HttpMethod.GET,entity,CustomerLoan[].class,uriVariables);
        
		
//		HashMap<String, Integer> uriVariables = new HashMap<>();
//		uriVariables.put("customerid", customerid);
//		uriVariables.put("loanid", loanid);

//		ResponseEntity<CustomerLoan[]> forEntity = restTemplate.getForEntity(
//				"http://localhost:9191/loan/getLoanDetails/{customerid}/{loanid}", CustomerLoan[].class, uriVariables);
//		CustomerLoan[] result = forEntity.getBody();
        CustomerLoan[] result = exchange.getBody();
        System.out.println(result);
		model.put("result", result);
		return "viewLoans";
	}
	
	


	@RequestMapping(value = "/collateral")
	public String returnToMainPage(ModelMap model) {
		return "Collateral";
	}
	
	
	@RequestMapping(value = "/collateral", method = RequestMethod.POST)
	public String GetCollateralValues(HttpSession session,ModelMap model, @RequestParam int collateralId, @RequestParam int loanId,
			@RequestParam int collateralvalue,@RequestParam int sanctionedLoan, @RequestParam String collateralType, @RequestParam String bankName,
			@RequestParam double depositAmount, @RequestParam double interestRate, @RequestParam int lockPeriodInMonths,
			@RequestParam String collateral_address, @RequestParam double rate_per_sq_ft, @RequestParam double area) {
		
		String token=(String) session.getAttribute("token");
        HttpHeaders header=new HttpHeaders();
        String JWT="Bearer "+token;
        header.add("Authorization",JWT);
        
		ForJson forj = new ForJson();
		forj.setLoanId(loanId);
		forj.setCollateralId(collateralId);
		forj.setCollateralvalue(collateralvalue);
		forj.setCollateralType(collateralType);
		forj.setSanctionedLoan(sanctionedLoan);
		forj.setBankName(bankName);
		forj.setDepositAmount(depositAmount);
		forj.setInterestRate(interestRate);
		forj.setLockPeriodInMonths(lockPeriodInMonths);
		forj.setCollateral_address(collateral_address);
		forj.setRate_per_sq_ft(rate_per_sq_ft);
		forj.setArea(area);
		
		HttpEntity<ForJson> entity=new  HttpEntity<ForJson>(forj,header);

        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9191/loan/loan/saveCollaterals",HttpMethod.POST,entity,String.class);


//		ResponseEntity<String> forEntity = restTemplate.postForEntity("http://localhost:9191/loan/loan/saveCollaterals", forj,
//				String.class);
		String result = exchange.getBody();
		model.put("result", result);
		return "redirect:/firstpage";
	}
	
	

	@RequestMapping(value = "/risk")
	public String showRisk(ModelMap model) {
		return "EnterRisk";
	}
	
	
	
	@RequestMapping(value = "/risk", method = RequestMethod.GET)
	public String RiskAssessment(HttpSession session,ModelMap model, @RequestParam int loanid) {
		
		String token=(String) session.getAttribute("token");
        HttpHeaders header=new HttpHeaders();
        String JWT="Bearer "+token;
        header.add("Authorization",JWT);
        HttpEntity<String> entity=new  HttpEntity<String>(header);
        
    	HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("loanid", loanid);

		
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9191/risk/risk/getCollateralRisk/{loanid}",HttpMethod.GET,entity,String.class,uriVariables);
		
		
		
//		HashMap<String, Integer> uriVariables = new HashMap<>();
//		uriVariables.put("loanid", loanid);

//		ResponseEntity<String> forEntity = restTemplate.getForEntity(
//				"http://localhost:9191/risk/getCollateralRisk/{loanid}", String.class, uriVariables);
		String result = exchange.getBody();
		String message;
		boolean value=false;
		if( result.equalsIgnoreCase("ok")) {
			value=true;
			message="No Risk On This Loan";
		}
		else {
			message="This Loan Is Risky";
		}
		model.put("message", message);
		model.put("value", value);

		return "ViewRisk";
	}

}
