package com.cg.homeloan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.exceptions.LoanAgreementNotFoundException;
import com.cg.homeloan.repositories.ILoanAgreementRepository;


@Service
public class LoanAgreementService {
	
	@Autowired
	ILoanAgreementRepository loanAgreementRepository; 
	
	public LoanAgreement addLoanAgreement(LoanAgreement loanAgreement) {
		LoanAgreement obj = loanAgreementRepository.save(loanAgreement); 
		return obj;
	}
	
	public List<LoanAgreement> getAllLoanAgreements(){
		List<LoanAgreement> list = loanAgreementRepository.findAll();
		return list;
	}

	/*
	 * public LoanAgreement updateLoanAgreement(int loanAgreementId, LoanAgreement
	 * loanAgreement) throws LoanAgreementNotFoundException{
	 * loanAgreementRepository.findById(loanAgreementId).orElseThrow(()->new
	 * LoanAgreementNotFoundException("Loan Agreement Not Found!")); return
	 * loanAgreementRepository.save(loanAgreement); }
	 * 
	 * 
	 * 
	 * public LoanAgreement deleteLoanAgreement(int loanAgreementId) throws
	 * LoanAgreementNotFoundException{ LoanAgreement loanAgreement
	 * =loanAgreementRepository.findById(loanAgreementId) .orElseThrow(()-> new
	 * LoanAgreementNotFoundException("Loan Agreement Not Found!"));
	 * loanAgreementRepository.deleteById(loanAgreementId); return loanAgreement; }
	 * 
	 * public List<LoanAgreement> retrieveAllLoanAgreement(){ return
	 * loanAgreementRepository.findAll(); }
	 * 
	 * public LoanAgreement retrieveLoanAgreementById(int loanAgreementId) throws
	 * LoanAgreementNotFoundException{ return
	 * loanAgreementRepository.findById(loanAgreementId) .orElseThrow(()-> new
	 * LoanAgreementNotFoundException("Loan Agreement Not Found!")); }
	 */	
	
}
