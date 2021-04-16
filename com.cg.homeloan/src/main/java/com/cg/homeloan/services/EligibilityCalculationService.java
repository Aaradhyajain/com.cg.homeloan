package com.cg.homeloan.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;

public class EligibilityCalculationService {

	@Autowired
	Customer customer;
	@Autowired
	LoanApplication loanApplication;
	
	public void checkEligilibity() {
		if(loanApplication.getLoanAppliedAmount()<=2*customer.getYearlySaving()) {
			loanApplication.setStatus(Status.WAITING_FOR_LAND_VERIFICATION_OFFICE_APPROVAL);
		}
		else if(loanApplication.getLoanAppliedAmount()> 2*customer.getYearlySaving()) {
			loanApplication.setLoanApprovedAmount(customer.getYearlySaving());
			loanApplication.setStatus(Status.WAITING_FOR_LAND_VERIFICATION_OFFICE_APPROVAL);
		}
	}
}
