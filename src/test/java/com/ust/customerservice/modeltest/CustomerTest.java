package com.ust.customerservice.modeltest;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import com.ust.customerservice.model.Customer;

public class CustomerTest {
	 Customer customer = new Customer();

	    @Test
	    public void CustomerTest() {
	        new BeanTester().testBean(Customer.class);


}
}



