package com.nayan.customer.service;

import com.nayan.customer.response.OrderResponse;

public interface IOrderService {
	OrderResponse getOrders(String Id);

	OrderResponse getOrderById(String custId, String ordId);
}
