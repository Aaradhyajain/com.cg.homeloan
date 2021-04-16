package com.cg.homeloan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.homeloan.entities.LandVerificationOfficer;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.exceptions.LandVerificationException;
import com.cg.homeloan.repositories.ILandVerificationRepository;
import com.cg.homeloan.repositories.ILoanApplicationRepository;

@Service
public class LandVerificationService implements ILandVerificationService {

	@Autowired
	ILoanApplicationRepository loanapplicationRepository;

	@Autowired
	ILandVerificationRepository iLandVerificationRepository;

	@Override
	public LoanApplication updateStatus(LoanApplication loanApplication) throws LandVerificationException {
		if (loanApplication.getStatus() == Status.WAITING_FOR_LAND_VERIFICATION_OFFICE_APPROVAL
				&& loanApplication.isLandVerificationApproval() == false) {
			loanApplication.setLandVerificationApproval(true);
			loanApplication.setStatus(Status.WAITING_FOR_FINANCE_APPROVAL);
			return loanapplicationRepository.save(loanApplication);
		} else {
			throw new LandVerificationException("Something went wrong");
		}
	}

	// saving a specific record by using the method save() of CrudRepository
	public LandVerificationOfficer addLandOfficer(LandVerificationOfficer officer) {
		iLandVerificationRepository.save(officer);
		return officer;
	}

	@Override
	public Boolean isValidLandOfficer(String username, String password) {
		return iLandVerificationRepository.findByUsernameAndPassword(username, password) != null ? true : false;
	}
}
