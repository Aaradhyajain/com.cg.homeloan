package com.cg.homeloan.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.exceptions.AdminApprovalException;
import com.cg.homeloan.exceptions.LoanApplicationNotFoundExcption;
import com.cg.homeloan.repositories.ILoanApplicationRepository;

@Service
public class LoanApplicationService implements ILoanApplicationService {

	@Autowired
	ILoanApplicationRepository loanapplicationRepository;

	@Override
	public LoanApplication addLoanApplication(LoanApplication loanApplication) {
		return loanapplicationRepository.save(loanApplication);
	}

	@Override
	public LoanApplication updateLoanApplication(int loanApplicationId, LoanApplication loanApplication)
			throws LoanApplicationNotFoundExcption {
		loanapplicationRepository.findById(loanApplicationId)
				.orElseThrow(() -> new LoanApplicationNotFoundExcption("Loan Application Not Found!!!"));
		return loanapplicationRepository.save(loanApplication);
	}

	@Override
	public LoanApplication deleteLoanApplication(int loanApplicationId) throws LoanApplicationNotFoundExcption {
		LoanApplication loanApplication = loanapplicationRepository.findById(loanApplicationId)
				.orElseThrow(() -> new LoanApplicationNotFoundExcption("Loan Application Not Found!!!"));
		loanapplicationRepository.deleteById(loanApplicationId);
		return loanApplication;
	}

	@Override
	public List<LoanApplication> retrieveAllLoanApplication() {
		return loanapplicationRepository.findAll();
	}

	@Override
	public LoanApplication retrieveLoanApplicationById(int loanApplicationId) throws LoanApplicationNotFoundExcption {
		return loanapplicationRepository.findById(loanApplicationId)
				.orElseThrow(() -> new LoanApplicationNotFoundExcption("Loan Application Not Found!!!"));
	}
	
	@Override
	public LoanApplication updateStatus(LoanApplication loanApplication) throws AdminApprovalException {
		if (loanApplication.getStatus() == Status.PENDING && loanApplication.isLandVerificationApproval() == true
				&& loanApplication.isFinanceVerificationApproval() == true) {
			loanApplication.setAdminApproval(true);
			loanApplication.setStatus(Status.APPROVED);
			return loanapplicationRepository.save(loanApplication);

		} else
			throw new AdminApprovalException("Something went wrong");
	}

}
