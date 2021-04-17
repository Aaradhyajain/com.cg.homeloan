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
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.exceptions.CustomerNotFoundException;
import com.cg.homeloan.exceptions.LoanApplicationNotFoundExcption;
import com.cg.homeloan.services.ILoanApplicationService;

@RestController
@RequestMapping("/homeloan")
public class LoanApplicationController {

	@Autowired
	ILoanApplicationService loanapplicationservice;

	@GetMapping("/LoanApplications")
	public ResponseEntity<List<LoanApplication>> getAllLoanApplications() {
		return new ResponseEntity<>(loanapplicationservice.getAllLoanApplication(), HttpStatus.OK);
	}

	@GetMapping("/LoanApplication/{loanApplicationId}")
	public ResponseEntity<LoanApplication> getLoanApplication(@PathVariable("loanApplicationId") int loanApplicationId) throws LoanApplicationNotFoundExcption {
		return new ResponseEntity<>(loanapplicationservice.getLoanApplication(loanApplicationId), HttpStatus.FOUND);
	}

	@PostMapping("/addLoanApplication/{userId}/{loanAppliedAmount}")
	public ResponseEntity<LoanApplication> addLoanApplication(@PathVariable int userId, @PathVariable double loanAppliedAmount) throws CustomerNotFoundException {
		return new ResponseEntity<>(loanapplicationservice.addLoanApplication(userId,loanAppliedAmount), HttpStatus.OK);
	}

	@PutMapping("/updateLoanApplication")
	public ResponseEntity<LoanApplication> updateLoanApplication(@PathVariable int loanApplicationId, @RequestBody LoanApplication loanApplication) throws LoanApplicationNotFoundExcption {
		return new ResponseEntity<>(loanapplicationservice.updateLoanApplication(loanApplicationId,loanApplication), HttpStatus.OK);
	}

	@DeleteMapping("/deleteLoanApplication/{loanApplicationId}")
	public ResponseEntity<LoanApplication> deleteLoanApplication(@PathVariable int loanApplicationId) throws LoanApplicationNotFoundExcption {
		return new ResponseEntity<>(loanapplicationservice.deleteLoanApplication(loanApplicationId), HttpStatus.FOUND);
	}

}