package com.akash.CustomerDataManagement.dto;

import java.io.Serializable;

import com.akash.CustomerDataManagement.entity.Customer;

import lombok.Data;

@Data
public class CustomerDTO implements Serializable {

	private Integer id;

	private String name;

	private String email;

	public CustomerDTO (Customer customer) {
		this.id=customer.getId();
		this.name=customer.getName();
		this.email=customer.getEmail();
	}

}
