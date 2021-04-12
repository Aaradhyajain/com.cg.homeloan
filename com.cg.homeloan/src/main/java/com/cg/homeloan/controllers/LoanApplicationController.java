package com.cg.homeloan.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.services.ILoanApplicationService;

@RestController
public class LoanApplicationController {

	@Autowired
	ILoanApplicationService loanapplicationservice;

	@GetMapping("/LoanApplication")
	public ResponseEntity<List<LoanApplication>> getLoanApplication() {
		List<LoanApplication> loanApplications = loanapplicationservice.retrieveAllLoanApplication();
		return new ResponseEntity<List<LoanApplication>>(loanApplications, HttpStatus.OK);
	}

	@GetMapping("/LoanApplication/{loanApplicationId}")
	public ResponseEntity<LoanApplication> getAdmin(@PathVariable("loanApplicationId") int loanApplicationId) {
		LoanApplication loanApplication = loanapplicationservice.retrieveLoanApplicationById(loanApplicationId);
		return new ResponseEntity<LoanApplication>(loanApplication, HttpStatus.OK);
	}

	@PostMapping("/addLoanApplication")
	public ResponseEntity<LoanApplication> addUser(@Valid @RequestBody LoanApplication loanApplication) {
		LoanApplication loanApplicationData = loanapplicationservice.addLoanApplication(loanApplication);
		return new ResponseEntity<LoanApplication>(loanApplicationData, HttpStatus.OK);
	}

	@PutMapping("/updateLoanApplication")
	public ResponseEntity<LoanApplication> updateUser(@Valid @RequestBody LoanApplication loanApplication) {
		LoanApplication loanApplicationData = loanapplicationservice.updateLoanApplication(loanApplication);
		return new ResponseEntity<LoanApplication>(loanApplicationData, HttpStatus.OK);
	}

	@DeleteMapping("/deleteLoanApplication/{loanApplicationId}")
	public ResponseEntity<String> deleteLoanApplication(@Valid @PathVariable int loanApplicationId) {
		loanapplicationservice.deleteLoanApplication(loanApplicationId);
		String message = "User Successfully Removed";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

}
