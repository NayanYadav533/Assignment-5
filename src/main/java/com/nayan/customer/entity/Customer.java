package com.nayan.customer.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Customer {
	private String id;
	private String name;
	private String email;
	private Long mobileNo;
	private String address;
	private List<Order> orders;
	
	public Customer() {}
}
