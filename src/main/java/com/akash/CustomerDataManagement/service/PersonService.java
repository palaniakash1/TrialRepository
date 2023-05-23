package com.akash.CustomerDataManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.CustomerDataManagement.entity.Person;
import com.akash.CustomerDataManagement.repository.PersonDAO;

@Service
public class PersonService {

	@Autowired
	private PersonDAO dao;
	
	public Person savePerson(Person person) {

		return dao.save(person);
	}
}
