package com.cg.homeloan.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.exceptions.AdminApprovalException;
import com.cg.homeloan.exceptions.CustomerNotFoundException;
import com.cg.homeloan.exceptions.FinanceVerificationException;
import com.cg.homeloan.exceptions.LandVerificationException;
import com.cg.homeloan.exceptions.LoanAgreementNotFoundException;
import com.cg.homeloan.exceptions.LoanApplicationNotFoundExcption;
import com.cg.homeloan.repositories.ICustomerRepository;
import com.cg.homeloan.repositories.ILoanApplicationRepository;

@Service
public class LoanApplicationService implements ILoanApplicationService {

	@Autowired
	ILoanApplicationRepository loanApplicationRepository;

	@Autowired
	LoanAgreementService lAgreementService;
	@Autowired
	ILoanAgreementService loanAgreementService;

	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public LoanApplication addLoanApplication(int userId, double loanAppliedAmount) throws CustomerNotFoundException {
		Customer customer = customerRepository.findById(userId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer detail not found !!!"));
		LoanApplication loanApplication = new LoanApplication(customer, loanAppliedAmount);
		return loanApplicationRepository.save(loanApplication);
	}

	@Override
	public LoanApplication updateLoanApplication(int loanApplicationId, LoanApplication loanApplication)
			throws LoanApplicationNotFoundExcption {
		loanApplicationRepository.findById(loanApplicationId)
				.orElseThrow(() -> new LoanApplicationNotFoundExcption("Loan Application Not Found!!!"));
		return loanApplicationRepository.save(loanApplication);
	}

	@Override
	public LoanApplication deleteLoanApplication(int loanApplicationId) throws LoanApplicationNotFoundExcption {
		LoanApplication loanApplication = loanApplicationRepository.findById(loanApplicationId)
				.orElseThrow(() -> new LoanApplicationNotFoundExcption("Loan Application Not Found!!!"));
		loanApplicationRepository.deleteById(loanApplicationId);
		return loanApplication;
	}

	@Override
	public List<LoanApplication> getAllLoanApplication() {
		return loanApplicationRepository.findAll();
	}

	@Override
	public LoanApplication getLoanApplication(int loanApplicationId) throws LoanApplicationNotFoundExcption {
		return loanApplicationRepository.findById(loanApplicationId)
				.orElseThrow(() -> new LoanApplicationNotFoundExcption("Loan Application Not Found!!!"));
	}

	@Override
	public LoanApplication updateLandStatus(int loanApplicationId)
			throws LandVerificationException, LoanApplicationNotFoundExcption {
		LoanApplication loanApplication = getLoanApplication(loanApplicationId);

		if (loanApplication.getStatus() == Status.WAITING_FOR_LAND_VERIFICATION_OFFICE_APPROVAL
				&& !loanApplication.isLandVerificationApproval()) {
			loanApplication.setLandVerificationApproval(true);
			loanApplication.setStatus(Status.WAITING_FOR_FINANCE_APPROVAL);
			return loanApplicationRepository.save(loanApplication);
		} else {
			throw new LandVerificationException("Something went wrong");
		}
	}

	@Override
	public LoanApplication updateFinanceStatus(int loanApplicationId)
			throws FinanceVerificationException, LoanApplicationNotFoundExcption {
		LoanApplication loanApplication = getLoanApplication(loanApplicationId);

		if (loanApplication.getStatus() == Status.WAITING_FOR_FINANCE_APPROVAL
				&& loanApplication.isLandVerificationApproval() && !loanApplication.isFinanceVerificationApproval()) {
			loanApplication.setFinanceVerificationApproval(true);
			loanApplication.setStatus(Status.PENDING);
			return loanApplicationRepository.save(loanApplication);

		} else
			throw new FinanceVerificationException("Something went wrong");
	}

	@Override
	public LoanApplication updateAdminStatus(int loanApplicationId)
			throws AdminApprovalException, LoanApplicationNotFoundExcption {
		LoanApplication loanApplication = getLoanApplication(loanApplicationId);

		if (loanApplication.getStatus() == Status.PENDING && loanApplication.isLandVerificationApproval()
				&& loanApplication.isFinanceVerificationApproval()) {
			loanApplication.setAdminApproval(true);
			loanApplication.setStatus(Status.APPROVED);
			loanApplication.setLoanApprovedAmount(loanApplication.getLoanAppliedAmount());
//			loanAgreementService.addLoanAgreement(loanApplicationId);
			LoanAgreement obj = new LoanAgreement();
			obj.setLoanApplicationId(loanApplication);
			try {
				lAgreementService.addLoanAgreement(obj) ;
			} catch (LoanAgreementNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return loanApplicationRepository.save(loanApplication);

		} else
			throw new AdminApprovalException("Something went wrong");
	}

}
