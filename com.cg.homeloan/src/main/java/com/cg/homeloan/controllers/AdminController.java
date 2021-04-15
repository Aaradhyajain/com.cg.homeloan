package com.cg.homeloan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.homeloan.entities.Admin;
import com.cg.homeloan.entities.FinanceVerificationOfficer;
import com.cg.homeloan.entities.LandVerificationOfficer;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.exceptions.AdminApprovalException;
import com.cg.homeloan.services.IAdminService;
import com.cg.homeloan.services.IFinanceVerificationService;
import com.cg.homeloan.services.ILandVerificationService;

@RestController
@RequestMapping("/homeloan")
public class AdminController {

	@Autowired
	IAdminService adminService;
	
	@Autowired
	IFinanceVerificationService financeVerificationService;
	
	@Autowired
	ILandVerificationService landVerificationService;

	@GetMapping("/Admin")
	public ResponseEntity<List<Admin>> viewAllAdmin() {
		return new ResponseEntity<List<Admin>>(adminService.viewAllAdmin(), HttpStatus.OK);
	}

	@GetMapping("/Admin/{userId}")
	public ResponseEntity<Admin> viewAdmin(@PathVariable("userId") int userId) {
		return new ResponseEntity<Admin>(adminService.viewAdmin(userId), HttpStatus.FOUND);
	}

	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.addAdmin(admin), HttpStatus.OK);
	}
	
	@PostMapping("/addFinanceOfficer")
	public ResponseEntity<FinanceVerificationOfficer> addFinanceOfficer(@RequestBody FinanceVerificationOfficer officer) {
		return new ResponseEntity<FinanceVerificationOfficer>(financeVerificationService.addFinanceOfficer(officer), HttpStatus.OK);
	}
	
	@PostMapping("/addLandOfficer")
	public ResponseEntity<LandVerificationOfficer> addLandOfficer(@RequestBody LandVerificationOfficer officer) {
		return new ResponseEntity<LandVerificationOfficer>(landVerificationService.addLandOfficer(officer),HttpStatus.OK);
	}	
	
	@PutMapping("/updateAdminVerificationStatus")
	public ResponseEntity<LoanApplication> updateLandStatus(@RequestBody LoanApplication loanApplication) throws AdminApprovalException {
		return new ResponseEntity<LoanApplication>(adminService.updateStatus(loanApplication), HttpStatus.OK);

	}
	
	//Validating the user
	@GetMapping("/validatingAdmin/{username}/{password}")
	public ResponseEntity<Boolean> isValidAdmin(@PathVariable String username,@PathVariable String password) {
		return new ResponseEntity<Boolean>(adminService.isValidAdmin(username, password),HttpStatus.OK);
	}
	
		

}