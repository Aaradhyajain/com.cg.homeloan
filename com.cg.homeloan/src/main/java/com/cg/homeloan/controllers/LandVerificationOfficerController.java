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
import com.cg.homeloan.exceptions.LandVerificationException;
import com.cg.homeloan.services.LandVerificationService;

@RestController
@RequestMapping("/homeloan")
public class LandVerificationOfficerController {

	@Autowired
	LandVerificationService landVerificationService;


	@PutMapping("/updateLandVerificationStatus")
	public ResponseEntity<LoanApplication> updateLandStatus(@RequestBody LoanApplication loanApplication) throws LandVerificationException {
		return new ResponseEntity<LoanApplication>(landVerificationService.updateStatus(loanApplication), HttpStatus.OK);

	}
	
	//Validating the user	
	@GetMapping("/validatingLandOfficer/{username}/{password}")
	public ResponseEntity<Boolean> isValidLandOfficer(@PathVariable String username,@PathVariable String password) {
		return new ResponseEntity<Boolean>(landVerificationService.isValidLandOfficer(username, password),HttpStatus.OK);
	}

}
