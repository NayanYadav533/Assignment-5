package com.nayan.customer.service;

import com.nayan.customer.response.CustomerResponse;

public interface ICustomerService {
	CustomerResponse getCustomers();

	CustomerResponse getCustomerDetailsById(String Id);
}
