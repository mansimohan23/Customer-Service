package com.ust.customerservice.servicetest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.ust.customerservice.Repository.CustomerRepository;
import com.ust.customerservice.exception.CustomerAlreadyExsists;
import com.ust.customerservice.exception.CustomerNotFound;
import com.ust.customerservice.model.Customer;
import com.ust.customerservice.service.CustomerServiceImpl;

@SpringBootTest
class CustomerServiceImplTest {

    @Mock
    CustomerRepository repo;

    @InjectMocks
    CustomerServiceImpl customerService;

    List<Customer> customerList = new ArrayList<>();

    Optional<Customer> options;

    Customer customer = new Customer();
  

    @Test
    public void saveCustomerTest() throws CustomerAlreadyExsists {
        Mockito.when(repo.save(customer)).thenReturn(customer);
        boolean flag = customerService.addCustomer(customer);
        Assertions.assertEquals(false,"Cannot Register User");

    }

    @Test
    public void updateCustomerTest() throws CustomerNotFound {
        Assertions.assertThrows(NullPointerException.class, () -> {
        Mockito.when(repo.findById(customer.getCustomerId())).thenReturn(options);
        Customer fetchuser = customerService.updateCustomer(customer.getCustomerId(), customer);
        Assertions.assertEquals(customer, fetchuser);
    });

    }

    @Test
    public void deleteCustomerTest() throws CustomerNotFound {
        Assertions.assertThrows(NullPointerException.class, () -> {
        Mockito.when(repo.findById(customer.getCustomerId())).thenReturn(options);
        boolean flag = customerService.deleteCustomer(customer.getCustomerId());
        Assertions.assertEquals(true, flag);
        });

    }
}
