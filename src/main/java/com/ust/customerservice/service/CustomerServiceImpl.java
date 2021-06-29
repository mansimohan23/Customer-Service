package com.ust.customerservice.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.customerservice.Repository.CustomerRepository;
import com.ust.customerservice.exception.CustomerAlreadyExsists;
import com.ust.customerservice.exception.CustomerNotFound;
import com.ust.customerservice.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository repo;

	@Override
	public boolean addCustomer(Customer customer) throws CustomerAlreadyExsists {
        //implement logic to check customer already exsists or not.If yes throw coustumer already exsists expecption
        repo.save(customer);
        return true;
    }
		
	

	@Override
	public Customer updateCustomer(String customerId, Customer customer) throws CustomerNotFound {
		
        try {
        	customer.setCustomer_id(customerId);
          
           return repo.save(customer);
        } catch (NoSuchElementException e) {
            throw new CustomerNotFound("User not found");
        }
    }
		
	@Override
	public boolean deleteCustomer(String customerId) throws CustomerNotFound {
		
		try {
            Customer fecthedUser = repo.findById(customerId).get();
            if (fecthedUser != null) {
                repo.delete(fecthedUser);
            }
        } catch (NoSuchElementException exception) {
            throw new CustomerNotFound("User does not exists");
        }
        return true;
    }



	@Override
	public Customer getCustomerById(String customerId) throws CustomerNotFound {
	        try {
	            return repo.findById(customerId).get();
	        } catch (NoSuchElementException e) {
	            throw new CustomerNotFound("User not found");
	        }
	    }

	    @Override
	    public List<Customer> getAllCustomers() {
	        return repo.findAll();
	    }
	}


