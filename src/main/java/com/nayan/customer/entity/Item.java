package com.nayan.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
	private String name;
	private int quantity;
	private int pricePerItem;
	
	public Item() {}
}
