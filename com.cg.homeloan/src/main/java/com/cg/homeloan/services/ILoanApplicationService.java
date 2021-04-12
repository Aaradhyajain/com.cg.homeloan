package com.cg.homeloan.services;

import java.util.List;

import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.repositories.ILoanApplicationRepository;

public interface ILoanApplicationService  {
	
	public LoanApplication addLoanApplication(LoanApplication loanApplication);
	
	public LoanApplication updateLoanApplication(LoanApplication loanApplication);
	public LoanApplication deleteLoanApplication(long loanApplicationId);
	public List<LoanApplication> retrieveAllLoanApplication();
	public LoanApplication retrieveLoanApplicationById(long loanApplicationId);
	
	

}
