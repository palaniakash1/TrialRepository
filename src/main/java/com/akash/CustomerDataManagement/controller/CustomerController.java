package com.akash.CustomerDataManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.akash.CustomerDataManagement.dto.CustomerDTO;
import com.akash.CustomerDataManagement.dto.ResponseStructure;
import com.akash.CustomerDataManagement.entity.Customer;
import com.akash.CustomerDataManagement.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;

//	

	@PostMapping("/customer")
	public @ResponseBody ResponseStructure<Customer> saveCustomer(@RequestBody CustomerDTO dto) {
//		System.err.println(customer);
		return service.saveCustomer(dto);
	}

	@PutMapping("/customer")
//	putmapping is used to particularly update the customer but it's not compulsory we can use post
	public @ResponseBody ResponseStructure<Object> updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}

	@GetMapping("/customer")
	public @ResponseBody ResponseStructure<List<Customer>> getAllCustomerData() {

		return service.getAllCustomerData();
	}

	@GetMapping("/customer/{id}")
	public @ResponseBody Customer getCustomerDataBy(@PathVariable("id") int id) {
		return service.getCustomerDataById(id);
	}
	
	@DeleteMapping("/customer/{id}")
	public @ResponseBody Customer deleteCustomerById(@PathVariable("id") int id) {
		return service.deleteCustomerById(id);
	}
	@GetMapping("/CustomerByName/{name}")
	public  @ResponseBody List<Customer> getCustomerByName(@PathVariable("name") String name) {

		return service.getCustomerByName(name);
		
	}
	@PostMapping("/validatecustomer")
	public List<Customer> validateCustomer(@RequestParam("name") String name,@RequestParam("email") String email) {
		return service.validateCustomer(name, email);
		
	}
}
