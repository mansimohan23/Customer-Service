package com.ust.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.customerservice.exception.CustomerNotFound;
import com.ust.customerservice.model.Customer;
import com.ust.customerservice.service.CustomerService;

@RestController
@RequestMapping("/api")

public class CustomerController {
	
	@Autowired
	CustomerService service;
	@Autowired
	public CustomerController(CustomerService service) {
		this.service=service;
	}
	
	@PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Customer customer) {
        try {
            if(!service.addCustomer(customer)) {
                throw new Exception();
            }
            return new ResponseEntity<String>("Created", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
	
	@PutMapping("/customer/{id}")
    public ResponseEntity<?> update(@PathVariable() String id, @RequestBody Customer customer) {
        try {
            return new ResponseEntity<Customer>(service.updateCustomer(id, customer), HttpStatus.OK);
        } catch (CustomerNotFound exception) {
            return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
	
	@DeleteMapping("/customer/{id}")
    public ResponseEntity<String> delete(@PathVariable() String id) {
        try {
            service.deleteCustomer(id);
            return new ResponseEntity<String>("Successfully Deleted Customer with id: " + id, HttpStatus.OK);
        } catch (CustomerNotFound exception) {
            return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

	@GetMapping("/customer/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable() String id) {
        try {
            return new ResponseEntity<Customer>(service.getCustomerById(id), HttpStatus.OK);
        } catch (CustomerNotFound e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customer/all-customer")
   
    public ResponseEntity<List<Customer>>getAllCustomer() {
        List<Customer>  customers=service.getAllCustomers();
        return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);

    }

}

	

