package com.cg.homeloan.services;

import java.util.List;

import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.exceptions.LoanApplicationNotFoundExcption;

public interface ILoanApplicationService {

	public List<LoanApplication> retrieveAllLoanApplication();

	public LoanApplication addLoanApplication(LoanApplication loanApplication);

	public LoanApplication retrieveLoanApplicationById(int loanApplicationId) throws LoanApplicationNotFoundExcption;

	public LoanApplication deleteLoanApplication(int loanApplicationId) throws LoanApplicationNotFoundExcption;

	public LoanApplication updateLoanApplication(int loanApplicationId, LoanApplication loanApplication)
			throws LoanApplicationNotFoundExcption;

}
