package com.cg.homeloan.controllers;

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
@RequestMapping("/homeloan")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.OK);
	}
	
	@GetMapping("/customer/{userId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("userId") int userId) throws CustomerNotFoundException {
		return new ResponseEntity<>(customerService.getCustomer(userId),HttpStatus.FOUND);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> viewAllCustomers(){
		return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
	}
	
	@PutMapping("/updateCustomer/{userId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int userId, @RequestBody Customer customer) throws CustomerNotFoundException {
		return new ResponseEntity<>(customerService.updateCustomer(userId,customer),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomer/{userId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int userId) throws CustomerNotFoundException{
		return new ResponseEntity<>(customerService.deleteCustomer(userId),HttpStatus.FOUND);
	}
	
	//Validating the user
	@GetMapping("/validatingCustomer/{username}/{password}")
	public boolean isValidCustomer(@PathVariable String username,@PathVariable String password) {
		return customerService.isValidCustomer(username, password);
	}

}
