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
import com.nayan.customer.entity.Order;
import com.nayan.customer.response.CustomerResponse;
import com.nayan.customer.response.OrderResponse;
import com.nayan.customer.service.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Override
	public OrderResponse getOrders(String id) {
		System.out.println("Get customer orders for customer id: " + id);
		List<Customer> customerData = getCustomerDetails();
		List<Order> orders = new ArrayList<Order>();
		customerData.forEach(cust -> {
			if(cust.getId().equalsIgnoreCase(id)){
				cust.getOrders().forEach(order -> {
					orders.add(order);
				});
			}
		});
		if(orders.isEmpty()) {
			return new OrderResponse(false, "Data Not found.");
		} 
		
		return new OrderResponse(true, "Data Found.", orders);
	}

	@Override
	public OrderResponse getOrderById(String custId, String ordId) {
		System.out.println("Get customer order details for customer id: " + custId + " and order id: " + ordId);
		Optional<Order> order = Optional.of(new Order());
		List<Customer> customerData = getCustomerDetails();
		customerData.forEach(cust -> {
			if(cust.getId().equalsIgnoreCase(custId)){
				cust.getOrders().forEach(ord -> {
					if(ord.getId().equalsIgnoreCase(ordId)) {
						order.get().setId(ord.getId());
						order.get().setPurchaseDate(ord.getPurchaseDate());
						order.get().setTotalAmount(ord.getTotalAmount());
						order.get().setItems(ord.getItems());
					}
				});
			}
		});
		if(!order.isPresent()) {
			return new OrderResponse(false, "Order data Not found for id: " + ordId);
		}
		return new OrderResponse(true, "Order data found.", order);
	}
	
	public List<Customer> getCustomerDetails(){
		List<Customer> customers = new ArrayList<Customer>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");
			customers = mapper.readValue(inputStream,typeReference);
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
