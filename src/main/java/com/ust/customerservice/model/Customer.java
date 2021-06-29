package com.ust.customerservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private String customerId;
	private String firstName;
	private String lastName;
	private String address;
	private double mobileNumber;
	private String emailId;
	
	public Customer() {
		super();
		
	}

	public Customer(String customerId, String firstName, String lastName, String address, double mobileNumber,
			String emailId) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomer_id(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(double mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + "]";
	}
	
	
	

}
