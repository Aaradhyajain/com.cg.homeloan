package com.cg.homeloan.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.exceptions.LandVerificationException;
import com.cg.homeloan.services.ILandVerificationService;

@RestController
public class LandVerificationOfficerController {

	@Autowired
	ILandVerificationService landVerificationService;


	@PutMapping("/updateLandVerificationStatus")
	public ResponseEntity<LoanApplication> updateLandStatus(@Valid @RequestBody LoanApplication loanApplication) throws LandVerificationException {
		LoanApplication loanApplicationData = landVerificationService.updateStatus(loanApplication);
		return new ResponseEntity<LoanApplication>(loanApplicationData, HttpStatus.OK);

	}

}
