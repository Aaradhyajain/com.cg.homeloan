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
import com.cg.homeloan.exceptions.AdminApprovalException;
import com.cg.homeloan.exceptions.LoanApplicationNotFoundExcption;
import com.cg.homeloan.services.ILoanApplicationService;

@RestController
@RequestMapping("/homeloan")
public class LoanApplicationController {

	@Autowired
	ILoanApplicationService loanapplicationservice;

	@GetMapping("/LoanApplications")
	public ResponseEntity<List<LoanApplication>> getAllLoanApplications() {
		return new ResponseEntity<List<LoanApplication>>(loanapplicationservice.retrieveAllLoanApplication(),
				HttpStatus.OK);
	}

	@GetMapping("/LoanApplication/{loanApplicationId}")
	public ResponseEntity<LoanApplication> getLoanApplication(@PathVariable("loanApplicationId") int loanApplicationId)
			throws LoanApplicationNotFoundExcption {
		return new ResponseEntity<LoanApplication>(
				loanapplicationservice.retrieveLoanApplicationById(loanApplicationId), HttpStatus.FOUND);
	}

	@PostMapping("/addLoanApplication")
	public ResponseEntity<LoanApplication> addLoanApplication(@RequestBody LoanApplication loanApplication) {
		return new ResponseEntity<LoanApplication>(loanapplicationservice.addLoanApplication(loanApplication),
				HttpStatus.OK);
	}

	@PutMapping("/updateLoanApplication")
	public ResponseEntity<LoanApplication> updateLoanApplication(@PathVariable int loanApplicationId,
			@RequestBody LoanApplication loanApplication) throws LoanApplicationNotFoundExcption {
		return new ResponseEntity<LoanApplication>(
				loanapplicationservice.updateLoanApplication(loanApplicationId, loanApplication), HttpStatus.OK);
	}

	@PutMapping("/updateAdminVerificationStatus")
	public ResponseEntity<LoanApplication> updateLandStatus(@RequestBody LoanApplication loanApplication)
			throws LoanApplicationNotFoundExcption {
		try {
			return new ResponseEntity<LoanApplication>(loanapplicationservice.updateStatus(loanApplication), HttpStatus.OK);
		} catch (AdminApprovalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@DeleteMapping("/deleteLoanApplication/{loanApplicationId}")
	public ResponseEntity<LoanApplication> deleteLoanApplication(@PathVariable int loanApplicationId)
			throws LoanApplicationNotFoundExcption {
		return new ResponseEntity<LoanApplication>(loanapplicationservice.deleteLoanApplication(loanApplicationId),
				HttpStatus.FOUND);
	}

}