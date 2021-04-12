package com.cg.homeloan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.exceptions.LandVerificationException;
import com.cg.homeloan.repositories.LoanApplicationRepository;

@Service
public class LandVerificationService implements ILandVerificationService {

	@Autowired
	LoanApplicationRepository loanapplicationRepository;

	@Override
	public LoanApplication updateStatus(LoanApplication loanApplication) throws LandVerificationException{
		if(loanApplication.getStatus()== Status.WAITING_FOR_LAND_VERIFICATION_OFFICE_APPROVAL 
						&& loanApplication.isLandVerificationApproval()==true 
							&& loanApplication.isFinanceVerificationApproval()==false ) 
		{
			loanApplication.setFinanceVerificationApproval(true);
			loanApplication.setStatus(Status.WAITING_FOR_FINANCE_APPROVAL);
			return loanapplicationRepository.save(loanApplication);	
		}
		else  
		{
		 throw new LandVerificationException("Something went wrong") ;	
	}	
	}
}
