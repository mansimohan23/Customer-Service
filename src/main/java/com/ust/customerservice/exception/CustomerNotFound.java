package com.ust.customerservice.exception;

@SuppressWarnings("serial")
public class CustomerNotFound extends Exception {
	
	public CustomerNotFound(String message) {
        super(message);
    }
}

