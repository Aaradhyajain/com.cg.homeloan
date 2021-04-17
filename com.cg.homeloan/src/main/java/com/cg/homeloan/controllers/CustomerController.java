package com.cg.homeloan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.exceptions.CustomerNotFoundException;
import com.cg.homeloan.exceptions.LoanApplicationNotFoundExcption;
import com.cg.homeloan.services.CustomerService;
import com.cg.homeloan.services.ILoanApplicationService;

@RestController
@RequestMapping("/homeloan/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ILoanApplicationService loanapplicationservice;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("userId") int userId) throws CustomerNotFoundException {
		return new ResponseEntity<>(customerService.getCustomer(userId),HttpStatus.OK);
	}
	
	@PutMapping("/updateCustomer/{userId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int userId, @RequestBody Customer customer) throws CustomerNotFoundException {
		return new ResponseEntity<>(customerService.updateCustomer(userId,customer),HttpStatus.OK);
	}
	
	@PostMapping("/applyLoan/{userId}/{loanAppliedAmount}")
	public ResponseEntity<LoanApplication> applyLoan(@PathVariable int userId, @PathVariable double loanAppliedAmount) throws CustomerNotFoundException {
		return new ResponseEntity<>(loanapplicationservice.addLoanApplication(userId,loanAppliedAmount), HttpStatus.OK);
	}
	
	@PostMapping("/loanTracker/{loanApplicationId}")
	public ResponseEntity<Status> loanTracker(int loanApplicationId) throws LoanApplicationNotFoundExcption{
		return new ResponseEntity<>(loanapplicationservice.checkStatus(loanApplicationId),HttpStatus.OK);
	}
	
	//Validating the user
	@GetMapping("/validatingCustomer/{username}/{password}")
	public boolean isValidCustomer(@PathVariable String username,@PathVariable String password) {
		return customerService.isValidCustomer(username, password);
	}

}
