package com.client;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.client.Controller.ClientController;

@SpringBootTest
class ClientApplicationTests {

    private MockMvc mockMvc;

    @InjectMocks
    private ClientController clientController;

    @BeforeEach
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(clientController)
                .build();
    }
    
    @Test
    public void testEnterEmail() throws Exception {
        this.mockMvc.perform(get("/firstpage"))
                .andExpect(status().isOk())
                .andExpect(view().name("EnterEmail"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

//    @Test
//    public void testHelloWorldJson() throws Exception {
//        mockMvc.perform(get("/hello/json")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title", Matchers.is("Greetings")))
//                .andExpect(jsonPath("$.value", Matchers.is("Hello World")))
//                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
//    }
}
