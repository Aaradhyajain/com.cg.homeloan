package com.cg.homeloan.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.exceptions.FinanceVerificationException;
import com.cg.homeloan.exceptions.LandVerificationException;
import com.cg.homeloan.repositories.LoanApplicationRepository;
import com.cg.homeloan.services.IFinanceVerificationService;

@RestController
public class FinanceVerificationOfficerController {
	
	@Autowired
	IFinanceVerificationService financeVerificationService;
	

	@PutMapping("/updateLandVerificationStatus")
	public ResponseEntity<LoanApplication> updateLandStatus(@Valid @RequestBody LoanApplication loanApplication) throws FinanceVerificationException {
		LoanApplication loanApplicationData = financeVerificationService.updateStatus(loanApplication);
		return new ResponseEntity<LoanApplication>(loanApplicationData, HttpStatus.OK);

	}

}
