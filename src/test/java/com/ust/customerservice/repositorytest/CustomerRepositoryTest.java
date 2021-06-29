package com.ust.customerservice.repositorytest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ust.customerservice.Repository.CustomerRepository;
import com.ust.customerservice.model.Customer;


@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    Customer customer = new Customer();

    @Test
    public void registerCustomerTest() {
        customerRepository.save(customer);
        Customer fetchedCustomer = customerRepository.findById("kkkk").get();
        Assertions.assertEquals(customer.getCustomer_id(), fetchedCustomer.getCustomer_id());

    }

    @Test
    public void deleteCustomerTest() {   
        customerRepository.save(customer);
        Customer fetchedcustomer = customerRepository.findById("kkkk").get();
        Assertions.assertEquals("kkkk", fetchedcustomer.getCustomer_id());
        customerRepository.delete(fetchedcustomer);
        fetchedcustomer = customerRepository.findById("kkkk").get();
        }

    

    @Test
    public void updateCustomerTest() {
        customerRepository.save(customer);
        Customer fetchedcustomer = customerRepository.findById("kkkk").get();
        customerRepository.save(fetchedcustomer);
        Assertions.assertEquals("kkkk", fetchedcustomer.getCustomer_id());
    }
}

 