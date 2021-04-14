package com.cg.homeloan.controllers;

import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.exceptions.LoanAgreementNotFoundException;
//import com.cg.homeloan.services.ILoanAgreementService;
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
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanAgreementController {

	@Autowired
	LoanAgreementService loanAgreementService;

	@GetMapping("/AllLoanAgreement")
	private ResponseEntity<List<LoanAgreement>> getAllAgreementList() {
		List<LoanAgreement> loanAgreement = loanAgreementService.getAllLoanAgreements();
		return new ResponseEntity<List<LoanAgreement>>(loanAgreement, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/LoanAgreement/{loanAgreementId}") public
	 * ResponseEntity<LoanAgreement> getAdmin(@PathVariable("loanAgreementId") int
	 * loanApplicationId) throws LoanAgreementNotFoundException { LoanAgreement
	 * loanAgreement =
	 * loanAgreementService.retrieveLoanAgreementById(loanApplicationId); return new
	 * ResponseEntity<LoanAgreement>(loanAgreement, HttpStatus.OK); }
	 */
	@PostMapping("/addLoanAgreement")
	public ResponseEntity<LoanAgreement> addUser(@RequestBody LoanAgreement loanAgreement) {
		LoanAgreement loanAgreementData = loanAgreementService.addLoanAgreement(loanAgreement);
		return new ResponseEntity<LoanAgreement>(loanAgreementData, HttpStatus.OK);
	}

	@PutMapping("/updateLoanAgreement/{loanAgreementId}")
	public ResponseEntity<LoanAgreement> updateUser(@PathVariable long loanAgreementId,
			@RequestBody LoanAgreement loanAgreement) throws LoanAgreementNotFoundException {
		LoanAgreement loanAgreementData = loanAgreementService.updateLoanAgreement(loanAgreementId, loanAgreement);
		return new ResponseEntity<LoanAgreement>(loanAgreementData, HttpStatus.OK);
	}

	@DeleteMapping("/deleteLoanAgreement/{loanAgreementId}")
	public ResponseEntity<LoanAgreement> deleteLoanAgreement(@PathVariable long loanAgreementId)
			throws LoanAgreementNotFoundException {
		LoanAgreement loanAgreement = loanAgreementService.deleteLoanAgreement(loanAgreementId);
		return new ResponseEntity<LoanAgreement>(loanAgreement, HttpStatus.OK);
	}

}
