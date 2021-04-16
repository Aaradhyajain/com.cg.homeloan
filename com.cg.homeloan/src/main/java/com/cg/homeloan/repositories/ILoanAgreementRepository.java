package com.cg.homeloan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.homeloan.entities.LoanAgreement;

public interface ILoanAgreementRepository extends JpaRepository<LoanAgreement, Long> {
	
//	public LoanAgreement addLoanAgreement(LoanAgreement loanAgreement);
//	public LoanAgreement updateLoanAgreement(LoanAgreement loanAgreement);
//	public LoanAgreement deleteLoanAgreement(int loanAgreementId);
//	public List<LoanAgreement> retrieveAllLoanAgreement();
//	public LoanAgreement retrieveLoanAgreementById(int loanAgreementId);
	
}