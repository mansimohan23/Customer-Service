package com.ust.customerservice.controllertest;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ust.customerservice.controller.CustomerController;
import com.ust.customerservice.exception.CustomerAlreadyExsists;
import com.ust.customerservice.model.Customer;
import com.ust.customerservice.service.CustomerService;


class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    CustomerService customerService;
    @InjectMocks
    CustomerController customerController;
    private Customer customer;

    

    @SuppressWarnings("deprecation")
	@Before(value = "")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        customer = new Customer();

    }

    @Test
    void registerCustomerTest() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            when(customerService.addCustomer(customer)).thenThrow(CustomerAlreadyExsists.class);
            mockMvc.perform(post("/register")
                    .contentType(MediaType.APPLICATION_JSON).content(asJsonString(customer)))
                    .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
        });

    }

    
    @Test
    void updateCustomerTest() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            when(customerService.updateUser(eq(customer.getCustomer_id()), any())).thenReturn(customer);
            mockMvc.perform(put("/customer/kkkk")
                    .contentType(MediaType.APPLICATION_JSON).content(asJsonString(customer)))
                    .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        });
    }

    @Test
    void deleteCustomerTest() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            when(customerService.deleteCustomer("kkkk")).thenReturn(true);
            mockMvc.perform(MockMvcRequestBuilders.delete("/user/Jack998")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
        });


    }
}

