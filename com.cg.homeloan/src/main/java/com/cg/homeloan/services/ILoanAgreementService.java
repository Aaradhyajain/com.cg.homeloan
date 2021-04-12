package com.cg.homeloan.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.homeloan.entities.LoanAgreement;

@Service
public interface ILoanAgreementService {

	public static LoanAgreement addLoanAgreement(LoanAgreement loanAgreement) {

		return null;
	}

	public static LoanAgreement updateLoanAgreement(LoanAgreement loanAgreement) {
		return null;
	}

	public static LoanAgreement deleteLoanAgreement(long loanAgreementId) {
		return null;
	}

	public List<LoanAgreement> retrieveAllLoanAgreement();

	public LoanAgreement retrieveLoanAgreementById(long loanAgreementId);

}
