package com.loan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.pojo.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findAllByEmail(String email);
	
	

}
