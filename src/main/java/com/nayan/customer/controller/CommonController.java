package com.nayan.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nayan.customer.entity.Customer;
import com.nayan.customer.entity.Order;
import com.nayan.customer.response.CustomerResponse;
import com.nayan.customer.response.OrderResponse;
import com.nayan.customer.service.ICustomerService;
import com.nayan.customer.service.IOrderService;
import com.nayan.customer.service.impl.CustomerService;

@RestController
public class CommonController {
	
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	IOrderService orderService;
	
	@GetMapping("/customers")
    public CustomerResponse getCustomersList() {
        return customerService.getCustomers();
    }

	@GetMapping("/customers/{id}")
    public CustomerResponse getCustomerDetailsById(@PathVariable("id") String id) {
        return customerService.getCustomerDetailsById(id);
    }
	
	@GetMapping("/customers/{id}/orders")
    public OrderResponse getOrdersList(@PathVariable("id") String id) {
        return orderService.getOrders(id);
    }

	@GetMapping("/customers/{custId}/orders/{ordId}")
    public OrderResponse getOrderDetailsById(@PathVariable("custId") String custId, @PathVariable("ordId") String ordId) {
        return orderService.getOrderById(custId, ordId);
    }
}
