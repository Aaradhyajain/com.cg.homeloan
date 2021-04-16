package com.cg.homeloan.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.homeloan.entities.Admin;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.exceptions.AdminApprovalException;
import com.cg.homeloan.repositories.IAdminRepository;
import com.cg.homeloan.repositories.ILoanApplicationRepository;

@Service
public class AdminService implements IAdminService {

	@Autowired
	IAdminRepository iAdminRepository;
	@Autowired
	ILoanApplicationRepository loanApplicationRepository;

	// saving a specific record by using the method save() of CrudRepository
	public Admin addAdmin(Admin admin) {
		iAdminRepository.save(admin);
		return admin;
	}

	// getting a specific record by using the method findById() of CrudRepository
	public Admin getAdmin(int userId) {
		return iAdminRepository.findById(userId).get();
	}

	// getting all Employee record by using the method findaAll() of CrudRepository
	public List<Admin> getAllAdmin() {
		List<Admin> admin = new ArrayList<Admin>();
		admin = iAdminRepository.findAll();
		return admin;
	}
	
	@Override
	public LoanApplication updateStatus(LoanApplication loanApplication) throws AdminApprovalException {
		if (loanApplication.getStatus() == Status.PENDING
				&& loanApplication.isLandVerificationApproval()==true 
				&& loanApplication.isFinanceVerificationApproval()==true) {
			loanApplication.setAdminApproval(true);
			loanApplication.setStatus(Status.APPROVED);
			return loanApplicationRepository.save(loanApplication);

		} else 
			throw new AdminApprovalException("Something went wrong");
	}
	
	@Override
	public Boolean isValidAdmin(String username, String password) {
		return iAdminRepository.findByUsernameAndPassword(username, password)!=null? true :false;
	}
	
}
