package com.cg.homeloan.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.entities.EMI;
import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.exceptions.LoanAgreementNotFoundException;
import com.cg.homeloan.exceptions.LoanApplicationNotFoundExcption;
import com.cg.homeloan.repositories.IEmiRepository;
import com.cg.homeloan.repositories.ILoanAgreementRepository;
import com.cg.homeloan.repositories.ILoanApplicationRepository;

@Service
public class LoanAgreementService implements ILoanAgreementService {

	@Autowired
	ILoanAgreementRepository loanAgreementRepository;
	@Autowired
	LoanApplicationService loanApplicationService;
	@Autowired
	EmiService emiService;
	@Autowired
	ILoanApplicationRepository loanApplicationRepository;

	@Autowired
	IEmiRepository emiRepository;
	@Override
	public LoanApplication getLoanApplication(int loanApplicationId) throws LoanApplicationNotFoundExcption {
		return loanApplicationRepository.findById(loanApplicationId)
				.orElseThrow(() -> new LoanApplicationNotFoundExcption("Loan Application Not Found!!!"));
	}

	/**
	 * implementation error not completed yet
	 */
	@Override
	public LoanAgreement addLoanAgreement(LoanAgreement loanApplicationId) throws LoanAgreementNotFoundException{
		

		
	//	Customer customer = customerRepository.findById(userId)
		EMI emi1= new EMI();
		emi1.setLoanAmount(loanApplicationId.getLoanApplicationId().getLoanApprovedAmount());
		emi1.setDueDate(LocalDate.now());
		emiService.addEmiDetails(emi1);
		
		
		
		
		//		interestAmount = 10;
//		tenure = 1;
//		interestAmount = interestAmount / (12 * 100);
//		tenure = tenure * 12;
//		emiAmount = (loanAmount * interestAmount * Math.pow(1 + interestAmount, tenure))
//				/ (Math.pow(1 + interestAmount, tenure) - 1);
//		return emiAmount;
		
		
		//formula for emi  
	//		EMI emi =
		/**
		 * call add method and add method of emi service
		 */
	//	LoanApplication loanApplication = new LoanApplication(customer, loanAppliedAmount)

		//LoanAgreement loanAgreement = new LoanAgreement(LoanAgreement loanApplicationId,emi1.addEmiDetails(emi));
		return loanAgreementRepository.save(loanApplicationId);
	}

	@Override
	public LoanAgreement getLoanAgreement(int loanAgreementId) throws LoanAgreementNotFoundException {
		return loanAgreementRepository.findById(loanAgreementId)
				.orElseThrow(() -> new LoanAgreementNotFoundException("Loan Agreement Not Found!"));
	}

	@Override
	public List<LoanAgreement> getAllLoanAgreements() {
		return loanAgreementRepository.findAll();
	}

	@Override
	public LoanAgreement deleteLoanAgreement(int loanAgreementId) throws LoanAgreementNotFoundException {
		LoanAgreement loanAgreement = getLoanAgreement(loanAgreementId);
		loanAgreementRepository.deleteById(loanAgreementId);
		return loanAgreement;
	}

	@Override
	public LoanAgreement updateLoanAgreement(int loanAgreementId, LoanAgreement loanAgreement)
			throws LoanAgreementNotFoundException {
		loanAgreementRepository.findById(loanAgreementId)
				.orElseThrow(() -> new LoanAgreementNotFoundException("Loan Agreement Not Found!"));
		return loanAgreementRepository.save(loanAgreement);
	}
	

}