package com.akash.CustomerDataManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.CustomerDataManagement.entity.BankAccount;

public interface BankRepository extends JpaRepository<BankAccount, Integer> {

}
