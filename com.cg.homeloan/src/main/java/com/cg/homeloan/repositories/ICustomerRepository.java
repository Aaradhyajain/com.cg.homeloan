package com.cg.homeloan.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.exceptions.CustomerNotFoundException;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
//	public Customer addCustomer(Customer customer);
//	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
//	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException;
//	public Customer viewCustomer(int custid) throws CustomerNotFoundException;
//	public List<Customer> viewAllCustomers();
//	public List<Customer> viewCustomerList(LocalDate dateOfApplication);
//	//public List<Customer> viewCustomerList(int theatreid);

}
