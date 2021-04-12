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
import com.cg.homeloan.exceptions.LoanApplicationNotFoundExcption;
import com.cg.homeloan.services.ILoanApplicationService;

@RestController
public class LoanApplicationController {

	@Autowired
	ILoanApplicationService loanapplicationservice;

	@GetMapping("/LoanApplication")
	public ResponseEntity<List<LoanApplication>> getAllLoanApplications() {
		List<LoanApplication> loanApplications = loanapplicationservice.retrieveAllLoanApplication();
		return new ResponseEntity<List<LoanApplication>>(loanApplications, HttpStatus.OK);
	}

	@GetMapping("/LoanApplication/{loanApplicationId}")
	public ResponseEntity<LoanApplication> getAdmin(@PathVariable("loanApplicationId") int loanApplicationId) throws LoanApplicationNotFoundExcption {
		LoanApplication loanApplication = loanapplicationservice.retrieveLoanApplicationById(loanApplicationId);
		return new ResponseEntity<LoanApplication>(loanApplication, HttpStatus.OK);
	}

	@PostMapping("/addLoanApplication")
	public ResponseEntity<LoanApplication> addUser(@RequestBody LoanApplication loanApplication) {
		LoanApplication loanApplicationData = loanapplicationservice.addLoanApplication(loanApplication);
		return new ResponseEntity<LoanApplication>(loanApplicationData, HttpStatus.OK);
	}

	@PutMapping("/updateLoanApplication")
	public ResponseEntity<LoanApplication> updateUser(@PathVariable int loanApplicationId, @RequestBody LoanApplication loanApplication) throws LoanApplicationNotFoundExcption {
		LoanApplication loanApplicationData = loanapplicationservice.updateLoanApplication(loanApplicationId,loanApplication);
		return new ResponseEntity<LoanApplication>(loanApplicationData, HttpStatus.OK);
	}

	@DeleteMapping("/deleteLoanApplication/{loanApplicationId}")
	public ResponseEntity<LoanApplication> deleteLoanApplication(@PathVariable int loanApplicationId) throws LoanApplicationNotFoundExcption {
		LoanApplication loanApplication = loanapplicationservice.deleteLoanApplication(loanApplicationId);
		return new ResponseEntity<LoanApplication>(loanApplication, HttpStatus.OK);
	}

}