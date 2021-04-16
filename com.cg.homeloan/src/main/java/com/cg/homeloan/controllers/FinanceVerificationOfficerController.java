package com.cg.homeloan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.exceptions.FinanceVerificationException;
import com.cg.homeloan.services.FinanceVerificationService;

@RestController
@RequestMapping("/homeloan")
public class FinanceVerificationOfficerController {

	@Autowired
	FinanceVerificationService financeVerificationService;

	@PutMapping("/updateFinanceVerificationStatus")
	public ResponseEntity<LoanApplication> updateFinanceStatus(@RequestBody LoanApplication loanApplication)
			throws FinanceVerificationException {
		return new ResponseEntity<LoanApplication>(financeVerificationService.updateStatus(loanApplication),
				HttpStatus.OK);

	}

	// Validating the user
	@GetMapping("/validatingFinanceOfficer/{username}/{password}")
	public ResponseEntity<Boolean> isValidFinanceOfficer(@PathVariable String username, @PathVariable String password) {
		return new ResponseEntity<Boolean>(financeVerificationService.isValidFinanceOfficer(username, password),
				HttpStatus.OK);
	}

}
