package com.akash.CustomerDataManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.CustomerDataManagement.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
