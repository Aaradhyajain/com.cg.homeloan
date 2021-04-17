package com.cg.homeloan.services;

import java.util.List;

import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.exceptions.LoanAgreementNotFoundException;

public interface ILoanAgreementService{
	
	public LoanAgreement addLoanAgreement(LoanAgreement loanAgreement) ;
		
		public LoanAgreement updateLoanAgreement(int loanAgreementId, LoanAgreement loanAgreement) throws LoanAgreementNotFoundException;
		public LoanAgreement deleteLoanAgreement(int loanAgreementId) throws LoanAgreementNotFoundException;
		public List<LoanAgreement> getAllLoanAgreements();
		public LoanAgreement getLoanAgreement(int loanAgreementId) throws LoanAgreementNotFoundException;
		
		




}
