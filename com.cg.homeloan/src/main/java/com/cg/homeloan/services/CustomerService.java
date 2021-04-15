package com.cg.homeloan.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.exceptions.CustomerNotFoundException;
import com.cg.homeloan.repositories.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	ICustomerRepository iCustomerRepository;
	
	@Override
	public Customer addCustomer(Customer customer) {
		iCustomerRepository.save(customer);
		return customer;
	}
	
	@Override
	public Customer viewCustomer(int userId) throws CustomerNotFoundException { 
		return iCustomerRepository.findById(userId).orElseThrow(()->new CustomerNotFoundException("Customer detail not found !!!"));
	}
	
	@Override
	public List<Customer> viewAllCustomers(){
		return iCustomerRepository.findAll();
	}
	
	@Override
	public Customer updateCustomer(int userId,Customer customer) throws CustomerNotFoundException {
		iCustomerRepository.findById(userId).orElseThrow(()->new CustomerNotFoundException("Customer detail not found !!!"));
		return iCustomerRepository.save(customer);
	}
	
	@Override
	public Customer deleteCustomer(int userId) throws CustomerNotFoundException {
		Customer customer = viewCustomer(userId);//iCustomerRepository.findById(userId).orElseThrow(()->new CustomerNotFoundException("Customer detail not found !!!"));
		
		iCustomerRepository.deleteById(userId);
		return customer;	
	}
	
	
	public boolean isValidCustomer(String username, String password) {
		return iCustomerRepository.findByUsernameAndPassword(username, password)!=null? true :false;
	}
	
//	public List<Customer> viewCustomerList(LocalDate dateOfApplication);


}
