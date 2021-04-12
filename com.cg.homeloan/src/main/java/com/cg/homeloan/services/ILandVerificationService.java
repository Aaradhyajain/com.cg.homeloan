package com.cg.homeloan.services;

import java.util.List;

import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.exceptions.LandVerificationException;

public interface ILandVerificationService {
	
	public LoanApplication updateStatus(LoanApplication loanApplication) throws LandVerificationException;

		}


