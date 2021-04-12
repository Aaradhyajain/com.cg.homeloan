package com.cg.homeloan.services;

import java.util.List;

import com.cg.homeloan.entities.LoanApplication;

public interface ILoanApplicationService {
	
	public List<LoanApplication> retrieveAllLoanApplication();
	public LoanApplication retrieveLoanApplicationById(int loanApplicationId);
	public LoanApplication deleteLoanApplication(int loanApplicationId);
	public LoanApplication updateLoanApplication(LoanApplication loanApplication);
	public LoanApplication addLoanApplication(LoanApplication loanApplication);

}
