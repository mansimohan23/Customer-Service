package com.ust.customerservice.service;

import java.util.List;

import com.ust.customerservice.exception.CustomerAlreadyExsists;
import com.ust.customerservice.exception.CustomerNotFound;
import com.ust.customerservice.model.Customer;

public interface CustomerService {

	boolean addCustomer(Customer customer) throws CustomerAlreadyExsists;

    Customer updateCustomer(String customerId,Customer customer) throws CustomerNotFound;

    boolean deleteCustomer(String customerId) throws CustomerNotFound;
    
    Customer getCustomerById(String customerId) throws CustomerNotFound;

    public List<Customer> getAllCustomers();



}
