package com.cg.homeloan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.exceptions.FinanceVerificationException;
import com.cg.homeloan.repositories.LoanApplicationRepository;

@Service
public class FinanceVerificationService implements IFinanceVerificationService {

	@Autowired
	LoanApplicationRepository loanapplicationRepository;

	@Override
	public LoanApplication updateStatus(LoanApplication loanApplication) throws FinanceVerificationException {
		if (loanApplication.getStatus() == Status.WAITING_FOR_FINANCE_APPROVAL
				&& loanApplication.isLandVerificationApproval() == false) {
			loanApplication.setLandVerificationApproval(true);
			loanApplication.setStatus(Status.PENDING);
			return loanapplicationRepository.save(loanApplication);

		} else {
			throw new FinanceVerificationException("Something went wrong");
		}
	}

}
