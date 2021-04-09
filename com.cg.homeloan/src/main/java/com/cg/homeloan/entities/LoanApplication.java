package com.cg.homeloan.entities;

import java.time.LocalDate;
public class LoanApplication {
	
	private long applicationId;
	private LocalDate applicationDate;
	private Customer customer;
	private double loanAppliedAmount;
	private double loanApprovedAmount;
	private boolean landVerificationApproval;
	private boolean financeVerificationApproval;
	private boolean adminApproval;
	private Status status;
	
	

}
