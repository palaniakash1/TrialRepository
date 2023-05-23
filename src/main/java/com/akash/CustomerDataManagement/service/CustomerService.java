package com.akash.CustomerDataManagement.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.akash.CustomerDataManagement.dto.CustomerDTO;
import com.akash.CustomerDataManagement.dto.ResponseStructure;
import com.akash.CustomerDataManagement.entity.Customer;
import com.akash.CustomerDataManagement.repository.CustomerDAO;
import com.akash.CustomerDataManagement.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerDAO dao;

	public ResponseStructure<Customer> saveCustomer(CustomerDTO dto) {
		Customer cus = new Customer(dto);
	
		Customer customer = dao.saveCustomer(dto);
		ResponseStructure<Customer> rs = new ResponseStructure<>();
		rs.setData(customer);
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setTimestamp(LocalDateTime.now());
		rs.setMessage("customer data saved successfully");
	
		return rs;
	
	}

	public ResponseStructure<List<Customer>> getAllCustomerData() {
//		 dao.getAllCustomerData();

		List<Customer> list = dao.getAllCustomerData();
		ResponseStructure<List<Customer>> rs = new ResponseStructure<>();

		if (list.size() != 0) {
			rs.setStatusCode(HttpStatus.FOUND.value());
			rs.setTimestamp(LocalDateTime.now());
			rs.setData(list);
			rs.setMessage("customers entey found in database");
		} else {
			rs.setData(list);
			rs.setStatusCode(HttpStatus.NOT_FOUND.value());
			rs.setTimestamp(LocalDateTime.now());
			rs.setMessage("no customer entry found in database");
		}
		return rs;

	}

	public ResponseStructure<Object> updateCustomer(Customer customer) {
//		save method in repostitory class is used to save and update the values

//		return dao.saveCustomer(customer);

		CustomerDTO dto = new CustomerDTO(customer);
		
		Customer cus = dao.saveCustomer(dto);

		ResponseStructure<Object> rs = new ResponseStructure<>();
		rs.setData(cus);
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setTimestamp(LocalDateTime.now());
		rs.setMessage(HttpStatus.ACCEPTED.name());
		return rs;
	}

	public Customer getCustomerDataById(int id) {

		return dao.getCustomerById(id);
	}

	public Customer deleteCustomerById(int id) {

		return dao.deleteCustomerDataById(id);
	}

	public List<Customer> getCustomerByName(String name) {

		return dao.getCustomerByName(name);
	}

	public List<Customer> validateCustomer(String name, String email) {

		return dao.validateCustomer(name, email);
	}

}
