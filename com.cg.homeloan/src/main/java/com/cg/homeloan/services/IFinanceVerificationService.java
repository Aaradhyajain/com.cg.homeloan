package com.cg.homeloan.services;

import com.cg.homeloan.entities.FinanceVerificationOfficer;

public interface IFinanceVerificationService  {
	
	public Boolean isValidFinanceOfficer(String userName, String password);
	public FinanceVerificationOfficer addFinanceOfficer(FinanceVerificationOfficer officer); 

}
