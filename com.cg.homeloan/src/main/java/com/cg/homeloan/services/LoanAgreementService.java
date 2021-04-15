package com.cg.homeloan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.exceptions.LoanAgreementNotFoundException;
import com.cg.homeloan.repositories.ILoanAgreementRepository;

@Service
public class LoanAgreementService implements ILoanAgreementService{

	@Autowired
	ILoanAgreementRepository loanAgreementRepository;
	
	@Override
	public LoanAgreement addLoanAgreement(LoanAgreement loanAgreement) {
		return loanAgreementRepository.save(loanAgreement); 
	}
	@Override
	public LoanAgreement getLoanAgreement(long loanAgreementId) throws LoanAgreementNotFoundException {
		// TODO Auto-generated method stub
		return loanAgreementRepository.findById(loanAgreementId).orElseThrow(() -> new LoanAgreementNotFoundException("Loan Agreement Not Found!"));
	}
	
	@Override
	public List<LoanAgreement> getAllLoanAgreements() {
		 return loanAgreementRepository.findAll();
	}
	
	@Override
	public LoanAgreement deleteLoanAgreement(long loanAgreementId) throws LoanAgreementNotFoundException {
		LoanAgreement loanAgreement = getLoanAgreement(loanAgreementId);
		loanAgreementRepository.deleteById(loanAgreementId);
		return loanAgreement;
	}
	
	@Override
	public LoanAgreement updateLoanAgreement(long loanAgreementId, LoanAgreement loanAgreement)
			throws LoanAgreementNotFoundException {
		loanAgreementRepository.findById(loanAgreementId)
				.orElseThrow(() -> new LoanAgreementNotFoundException("Loan Agreement Not Found!"));
		return loanAgreementRepository.save(loanAgreement);
	}

}