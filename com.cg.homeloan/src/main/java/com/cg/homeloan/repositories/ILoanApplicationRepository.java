package com.cg.homeloan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeloan.entities.LoanApplication;

public interface ILoanApplicationRepository extends JpaRepository<LoanApplication, Integer> {
	
//	public LoanApplication addLoanApplication(LoanApplication loanApplication);
//	public LoanApplication updateLoanApplication(LoanApplication loanApplication);
//	public LoanApplication deleteLoanApplication(int loanApplicationId);
//	public List<LoanApplication> retrieveAllLoanApplication();
//	public LoanApplication retrieveLoanApplicationById(int loanApplicationId);

}
