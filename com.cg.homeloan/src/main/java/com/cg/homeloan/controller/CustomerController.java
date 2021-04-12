package com.cg.homeloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.exceptions.CustomerNotFoundException;
import com.cg.homeloan.services.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer customer1 = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(customer1,HttpStatus.OK);
	}
	
	@RequestMapping("/customer/{userId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("userId") int userId) throws CustomerNotFoundException {
		Customer customer=customerService.getCustomer(userId);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customerList = customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
	}
	
	@PutMapping("/customer/{userId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int userId, @RequestBody Customer customer) throws CustomerNotFoundException {
		Customer customer1 = customerService.updateCustomer(userId,customer);
		return new ResponseEntity<Customer>(customer1,HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/{userId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int userId) throws CustomerNotFoundException{
		Customer customer=customerService.deleteCustomer(userId);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}

}
