package com.cg.homeloan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.homeloan.entities.FinanceVerificationOfficer;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.exceptions.FinanceVerificationException;
import com.cg.homeloan.repositories.IFinanceVerificationRepository;
import com.cg.homeloan.repositories.ILoanApplicationRepository;

@Service
public class FinanceVerificationService implements IFinanceVerificationService {

	@Autowired
	ILoanApplicationRepository loanApplicationRepository;

	@Autowired
	IFinanceVerificationRepository iFinanceVerificationRepository;

	@Override
	public LoanApplication updateStatus(LoanApplication loanApplication) throws FinanceVerificationException {
		if (loanApplication.getStatus() == Status.WAITING_FOR_FINANCE_APPROVAL
				&& loanApplication.isLandVerificationApproval() == true
				&& loanApplication.isFinanceVerificationApproval() == false) {
			loanApplication.setFinanceVerificationApproval(true);
			loanApplication.setStatus(Status.PENDING);
			return loanApplicationRepository.save(loanApplication);

		} else
			throw new FinanceVerificationException("Something went wrong");
	}

	// saving a specific record by using the method save() of CrudRepository
	public FinanceVerificationOfficer addFinanceOfficer(FinanceVerificationOfficer officer) {
		iFinanceVerificationRepository.save(officer);
		return officer;
	}

	@Override
	public Boolean isValidFinanceOfficer(String username, String password) {
		return iFinanceVerificationRepository.findByUsernameAndPassword(username, password) != null ? true : false;
	}

}