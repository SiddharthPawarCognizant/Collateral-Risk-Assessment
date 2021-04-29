package com.collaterloan.collateralmanagement;

 

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.collaterloan.collateralmanagement.Entity.CollateralLoan;
import com.collaterloan.collateralmanagement.Entity.Real_Estate;
import com.collaterloan.collateralmanagement.controller.CollateralController;
import com.collaterloan.collateralmanagement.repository.CashDepositRepository;
import com.collaterloan.collateralmanagement.repository.RealEstateRepository;
import com.collaterloan.collateralmanagement.service.CollateralLoanService;

 

@ContextConfiguration(classes = {CollateralManagementServiceApplication.class,MyRunner.class})
@WebMvcTest(CollateralController.class)
@ActiveProfiles("test")
class CollateralMockTests {
    
    @Autowired
    private MockMvc mvc;
    

    
    @MockBean
    private CollateralLoanService collateralLoanService;
    
    @MockBean
    RealEstateRepository realEstateRepository;
    
    @MockBean
    CashDepositRepository cashDepositRepository;
    
    @BeforeEach
    public void setup() {
        CollateralController collateralController = new CollateralController();
        mvc = MockMvcBuilders.standaloneSetup(collateralController).build();
    }
    
    @Test
    public void testGetCollateralDetails() throws Exception {
        
        CollateralLoan cl = new Real_Estate(1, 1, 50000,30000,"RealEstate", "Mumbai", 20, 2500);
        Mockito.when(collateralLoanService.getColateralLoan(1)).thenReturn(cl);
        mvc.perform(MockMvcRequestBuilders.get("/getCollaterals/{id}",1)
                .accept(MediaType.APPLICATION_JSON))
        .andDo(print());

 

    }

 

}
 