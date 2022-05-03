package com.nayan.customer.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
	private String id;
	private int totalAmount;
	private String purchaseDate;
	private List<Item> items;
	
	public Order() {}
}