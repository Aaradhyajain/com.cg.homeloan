package com.cg.homeloan.services;

import com.cg.homeloan.entities.LandVerificationOfficer;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.exceptions.LandVerificationException;

public interface ILandVerificationService {
	public LoanApplication updateStatus(LoanApplication loanApplication) throws LandVerificationException;
	
	
	public Boolean isValidLandOfficer(String username, String password);
	
	public LandVerificationOfficer addLandOfficer(LandVerificationOfficer officer); 
}


