package com.akash.CustomerDataManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.akash.CustomerDataManagement.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByName(String name);

	@Query("SELECT c FROM Customer c WHERE c.name=:name AND c.email=:email")
	List<Customer> validateCustomer(@Param("name") String name, @Param("email") String email);
}
