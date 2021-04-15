package com.cg.homeloan.services;

import java.util.List;

import com.cg.homeloan.entities.Admin;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.exceptions.AdminApprovalException;

public interface IAdminService {

	public Admin addAdmin(Admin admin); 
	public Admin viewAdmin(int userId);
	public List<Admin> viewAllAdmin();
	public LoanApplication updateStatus(LoanApplication loanApplication) throws AdminApprovalException;
	//public Admin validateAdmin(Admin admin);
	public Boolean isValidAdmin(String username, String password);
	}

