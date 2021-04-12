package com.cg.homeloan.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.exceptions.LoanAgreementNotFoundException;

public interface ILoanAgreementService{

	public LoanAgreement addLoanAgreement(LoanAgreement loanAgreement);

	public LoanAgreement updateLoanAgreement(int loanAgreementId, LoanAgreement loanAgreement)
			throws LoanAgreementNotFoundException;

	public LoanAgreement deleteLoanAgreement(long loanAgreementId) throws LoanAgreementNotFoundException;

	public List<LoanAgreement> retrieveAllLoanAgreement();

	public LoanAgreement retrieveLoanAgreementById(int loanAgreementId) throws LoanAgreementNotFoundException;

}
