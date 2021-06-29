package com.ust.customerservice.exception;

@SuppressWarnings("serial")
public class CustomerAlreadyExsists extends Exception {

	public CustomerAlreadyExsists(String message) {
		super(message);
	}
}