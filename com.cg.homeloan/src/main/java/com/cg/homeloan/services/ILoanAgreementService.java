package com.cg.homeloan.services;

import java.util.List;

import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.exceptions.LoanAgreementNotFoundException;

public interface ILoanAgreementService {

	public LoanAgreement addLoanAgreement(LoanAgreement loanAgreement);

	public LoanAgreement updateLoanAgreement(long loanAgreementId, LoanAgreement loanAgreement)
			throws LoanAgreementNotFoundException;

	public LoanAgreement deleteLoanAgreement(long loanAgreementId) throws LoanAgreementNotFoundException;

	public List<LoanAgreement> getAllLoanAgreements();

	public LoanAgreement getLoanAgreement(long loanAgreementId) throws LoanAgreementNotFoundException;

}
