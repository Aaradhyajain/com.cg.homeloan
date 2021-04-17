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

import com.cg.homeloan.entities.Admin;
import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.entities.FinanceVerificationOfficer;
import com.cg.homeloan.entities.LandVerificationOfficer;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.exceptions.AdminApprovalException;
import com.cg.homeloan.exceptions.CustomerNotFoundException;
import com.cg.homeloan.exceptions.LoanApplicationNotFoundExcption;
import com.cg.homeloan.services.CustomerService;
import com.cg.homeloan.services.IAdminService;
import com.cg.homeloan.services.IFinanceVerificationService;
import com.cg.homeloan.services.ILandVerificationService;
import com.cg.homeloan.services.ILoanApplicationService;

@RestController
@RequestMapping("/homeloan/admin")
public class AdminController {

	@Autowired
	IAdminService adminService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	IFinanceVerificationService financeVerificationService;
	
	@Autowired
	ILandVerificationService landVerificationService;
	
	@Autowired
	ILoanApplicationService loanApplicationService;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<>(adminService.addAdmin(admin), HttpStatus.OK);
	}
	
	@PostMapping("/addFinanceOfficer")
	public ResponseEntity<FinanceVerificationOfficer> addFinanceOfficer(@RequestBody FinanceVerificationOfficer officer) {
		return new ResponseEntity<>(financeVerificationService.addFinanceOfficer(officer), HttpStatus.OK);
	}
	
	@PostMapping("/addLandOfficer")
	public ResponseEntity<LandVerificationOfficer> addLandOfficer(@RequestBody LandVerificationOfficer officer) {
		return new ResponseEntity<>(landVerificationService.addLandOfficer(officer),HttpStatus.OK);
	}	
	
	@GetMapping("/{userId}")
	public ResponseEntity<Admin> viewAdmin(@PathVariable("userId") int userId) {
		return new ResponseEntity<>(adminService.getAdmin(userId), HttpStatus.OK);
	}
	
	@GetMapping("/Admins")
	public ResponseEntity<List<Admin>> viewAllAdmin() {
		return new ResponseEntity<>(adminService.getAllAdmin(), HttpStatus.OK);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> viewAllCustomers(){
		return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
	}
	
	@GetMapping("/LoanApplications")
	public ResponseEntity<List<LoanApplication>> getAllLoanApplications() {
		return new ResponseEntity<>(loanApplicationService.getAllLoanApplication(), HttpStatus.OK);
	}
	
	@PutMapping("/updateAdminVerificationStatus/{loanApplicationId}")
	public ResponseEntity<LoanApplication> updateAdminStatus(@PathVariable int loanApplicationId) throws AdminApprovalException, LoanApplicationNotFoundExcption {
		return new ResponseEntity<>(loanApplicationService.updateAdminStatus(loanApplicationId), HttpStatus.OK);

	}
	
	//Validating the user
	@GetMapping("/validatingAdmin/{username}/{password}")
	public ResponseEntity<Boolean> isValidAdmin(@PathVariable String username,@PathVariable String password) {
		return new ResponseEntity<>(adminService.isValidAdmin(username, password),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomer/{userId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int userId) throws CustomerNotFoundException{
		return new ResponseEntity<>(customerService.deleteCustomer(userId),HttpStatus.OK);
	}
	
}