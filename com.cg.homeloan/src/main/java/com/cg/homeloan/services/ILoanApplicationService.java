package com.cg.homeloan.services;

import java.util.List;

import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.exceptions.AdminApprovalException;
import com.cg.homeloan.exceptions.CustomerNotFoundException;
import com.cg.homeloan.exceptions.FinanceVerificationException;
import com.cg.homeloan.exceptions.LandVerificationException;
import com.cg.homeloan.exceptions.LoanApplicationNotFoundExcption;

public interface ILoanApplicationService  {
	
	public LoanApplication addLoanApplication(int userId, double loanAppliedAmount) throws CustomerNotFoundException;
	
	public LoanApplication updateLoanApplication(int loanApplicationId,LoanApplication loanApplication) throws LoanApplicationNotFoundExcption;
	public LoanApplication deleteLoanApplication(int loanApplicationId) throws LoanApplicationNotFoundExcption;
	public List<LoanApplication> getAllLoanApplication();
	public LoanApplication getLoanApplication(int loanApplicationId) throws LoanApplicationNotFoundExcption;
	public LoanApplication updateLandStatus(int loanApplicationId) throws LandVerificationException,LoanApplicationNotFoundExcption;
	public LoanApplication updateFinanceStatus(int loanApplicationId) throws FinanceVerificationException, LoanApplicationNotFoundExcption;
	public LoanApplication updateAdminStatus(int loanApplicationId) throws AdminApprovalException, LoanApplicationNotFoundExcption;
	public Status checkStatus(int loanApplicationId)throws LoanApplicationNotFoundExcption;
	

}
