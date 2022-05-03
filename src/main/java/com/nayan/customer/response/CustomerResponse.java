package com.nayan.customer.response;

import java.util.List;
import java.util.Optional;

import com.nayan.customer.entity.Customer;

public class CustomerResponse {
	private Boolean statusFlag;
	private String statusMessage;
	private List<Customer> customers;
	private Optional<Customer> customer;
	
	public CustomerResponse() { }
	
	public CustomerResponse(Boolean statusFlag, String statusMessage) {
		this.setStatusFlag(statusFlag);
		this.setStatusMessage(statusMessage);
	}
	
	public CustomerResponse(Boolean statusFlag, String statusMessage, List<Customer> customers) {
		this.setStatusFlag(statusFlag);
		this.setStatusMessage(statusMessage);
		this.setCustomers(customers);
	}
	
	public CustomerResponse(Boolean statusFlag, String statusMessage, Optional<Customer> customer) {
		this.setStatusFlag(statusFlag);
		this.setStatusMessage(statusMessage);
		this.setCustomer(customer);
	}

	public Boolean getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(Boolean statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Optional<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Optional<Customer> customer) {
		this.customer = customer;
	}
	
}
