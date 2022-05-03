package com.nayan.customer.response;

import java.util.List;
import java.util.Optional;

import com.nayan.customer.entity.Order;

public class OrderResponse {
	private Boolean statusFlag;
	private String statusMessage;
	private List<Order> orders;
	private Optional<Order> order;
	
	public OrderResponse() { }
	
	public OrderResponse(Boolean statusFlag, String statusMessage) {
		this.setStatusFlag(statusFlag);
		this.setStatusMessage(statusMessage);
	}
	
	public OrderResponse(Boolean statusFlag, String statusMessage, List<Order> orders) {
		this.setStatusFlag(statusFlag);
		this.setStatusMessage(statusMessage);
		this.setOrders(orders);
	}
	
	public OrderResponse(Boolean statusFlag, String statusMessage, Optional<Order> order) {
		this.setStatusFlag(statusFlag);
		this.setStatusMessage(statusMessage);
		this.setOrder(order);
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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Optional<Order> getOrder() {
		return order;
	}

	public void setOrder(Optional<Order> order2) {
		this.order = order2;
	}
}
