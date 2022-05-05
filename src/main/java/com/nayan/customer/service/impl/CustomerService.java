package com.nayan.customer.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nayan.customer.entity.Customer;
import com.nayan.customer.response.CustomerResponse;
import com.nayan.customer.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {

	@Override
	public CustomerResponse getCustomers() {
		System.out.println("Get all customers");
		List<Customer> customers = getCustomerDetails();
		if (customers.isEmpty()) {
			return new CustomerResponse(false, "Data Not found.");
		}

		return new CustomerResponse(true, "Data Found.", customers);
	}

	@Override
	public CustomerResponse getCustomerDetailsById(String id) {
		System.out.println("Get customer details for id: " + id);
		List<Customer> customerData = getCustomerDetails();
		Optional<Customer> customer = Optional.of(new Customer());
		customerData.forEach(cust -> {
			if (cust.getId().equalsIgnoreCase(id)) {
				customer.get().setId(cust.getId());
				customer.get().setName(cust.getName());
				customer.get().setEmail(cust.getEmail());
				customer.get().setMobileNo(cust.getMobileNo());
				customer.get().setAddress(cust.getAddress());
				customer.get().setOrders(cust.getOrders());
			}
		});
		if (!customer.isPresent()) {
			return new CustomerResponse(false, "Customer data Not found for id: " + id);
		}
		return new CustomerResponse(true, "Customer data found.", customer);
	}

	public List<Customer> getCustomerDetails() {
		List<Customer> customers = new ArrayList<Customer>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");
			customers = mapper.readValue(inputStream, typeReference);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customers;
	}

}
