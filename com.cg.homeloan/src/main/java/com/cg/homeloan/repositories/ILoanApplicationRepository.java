package com.cg.homeloan.repositories;

import java.util.List;

import com.cg.homeloan.entities.LoanApplication;

public interface ILoanApplicationRepository {
	
	public LoanApplication addLoanApplication(LoanApplication loanApplication);
	
	public LoanApplication updateLoanApplication(LoanApplication loanApplication);
	public LoanApplication deleteLoanApplication(long loanApplicationId);
	public List<LoanApplication> retrieveAllLoanApplication();
	public LoanApplication retrieveLoanApplicationById(long loanApplicationId);
	
	

}
