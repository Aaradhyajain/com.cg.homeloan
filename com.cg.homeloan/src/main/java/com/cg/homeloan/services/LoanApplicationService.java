package com.cg.homeloan.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.repositories.LoanApplicationRepository;

@Service
public class LoanApplicationService implements ILoanApplicationService {

	@Autowired
	LoanApplicationRepository loanapplicationRepository;

	@Override
	public LoanApplication addLoanApplication(LoanApplication loanApplication) {
		loanapplicationRepository.save(loanApplication);
		return loanApplication;
	}

	@Override
	public LoanApplication updateLoanApplication(LoanApplication loanApplication) {
		LoanApplication loanApplication2 =  loanapplicationRepository.save(loanApplication);		
		return loanApplication2;
	}

	@Override
	public LoanApplication deleteLoanApplication(int loanApplicationId) {
		LoanApplication loanApplication2 = loanapplicationRepository.findById(loanApplicationId).orElse(null);
		loanapplicationRepository.deleteById(loanApplicationId);
		return loanApplication2;
	}

	@Override
	public List<LoanApplication> retrieveAllLoanApplication() {
		List<LoanApplication> loanApplication = loanapplicationRepository.findAll();
		return loanApplication;
	}

	@Override
	public LoanApplication retrieveLoanApplicationById(int loanApplicationId) {
		return loanapplicationRepository.findById(loanApplicationId).get();
	}

}
