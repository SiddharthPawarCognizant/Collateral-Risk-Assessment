package com.loan;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.loan.controller.LoanController;

@SpringBootTest
public class MockMvcTest {
	
	  private MockMvc mockMvc;	
	
	 @InjectMocks
	LoanController LoanController;
	 
	 
	  @BeforeEach
	    public void setUp() throws Exception {
		  mockMvc = MockMvcBuilders.standaloneSetup(LoanController)
	                .build();
	    }
	  
//	  @Test
//	    public void testHelloWorld() throws Exception {
//		  
//		  mockMvc.perform(get("/getCustomer/json")
//	                .accept(MediaType.APPLICATION_JSON))
//	                .andExpect(status().isOk())
//	                .andExpect(jsonPath("$.title", Matchers.is("Greetings")))
//	                .andExpect(jsonPath("$.value", Matchers.is("Hello World")))
//	                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
//		  
//	  
//	  }

}
