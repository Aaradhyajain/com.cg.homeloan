package com.cg.homeloan.services;

import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.exceptions.LandVerificationException;

public interface ILandVerificationService {
	public LoanApplication updateStatus(LoanApplication loanApplication) throws LandVerificationException;
	
}


