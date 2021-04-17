package com.cg.homeloan.controllers;

import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.exceptions.LoanAgreementNotFoundException;
import com.cg.homeloan.services.LoanAgreementService;

import java.util.*;

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

@RestController
@RequestMapping("/homeloan")
public class LoanAgreementController {

	@Autowired
	LoanAgreementService loanAgreementService;

	@GetMapping("/AllLoanAgreement")
	public ResponseEntity<List<LoanAgreement>> getAllAgreementList() {
		return new ResponseEntity<>(loanAgreementService.getAllLoanAgreements(), HttpStatus.OK);
	}

	@GetMapping("/LoanAgreement/{loanAgreementId}") public
	ResponseEntity<LoanAgreement> getLoanAgreement(@PathVariable("loanAgreementId") int loanApplicationId) throws LoanAgreementNotFoundException { 
		return new ResponseEntity<>(loanAgreementService.getLoanAgreement(loanApplicationId), HttpStatus.OK);
	}
	
	@PostMapping("/addLoanAgreement")
	public ResponseEntity<LoanAgreement> addLoanAgreement(@RequestBody LoanAgreement loanAgreement) throws LoanAgreementNotFoundException{
		return new ResponseEntity<>(loanAgreementService.addLoanAgreement(loanAgreement), HttpStatus.OK);
	}

	@PutMapping("/updateLoanAgreement")
	public ResponseEntity<LoanAgreement> updateLoanAgreement(@PathVariable int loanAgreementId,@RequestBody LoanAgreement loanAgreement) throws LoanAgreementNotFoundException {
		return new ResponseEntity<>(loanAgreementService.updateLoanAgreement(loanAgreementId, loanAgreement), HttpStatus.OK);
	}

	@DeleteMapping("/deleteLoanAgreement/{loanAgreementId}")
	public ResponseEntity<LoanAgreement> deleteLoanAgreement(@PathVariable int loanAgreementId) throws LoanAgreementNotFoundException {
		return new ResponseEntity<>(loanAgreementService.deleteLoanAgreement(loanAgreementId), HttpStatus.OK);
	}

}