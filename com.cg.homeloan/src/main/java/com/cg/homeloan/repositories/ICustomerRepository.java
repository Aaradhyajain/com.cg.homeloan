package com.cg.homeloan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.homeloan.entities.Customer;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByUserNameAndPassword(String userName, String password);
}
