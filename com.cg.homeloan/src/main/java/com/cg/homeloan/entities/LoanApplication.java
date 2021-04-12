package com.cg.homeloan.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loanapplication")
public class LoanApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int loanApplicationId;
	@Column
	private LocalDate loanApplicationDate;
	
	@OneToOne
	private Customer customer;
	
	@Column
	private double loanAppliedAmount;
	@Column
	private double loanApprovedAmount;
	@Column
	private boolean landVerificationApproval;
	@Column
	private boolean financeVerificationApproval;
	@Column
	private boolean adminApproval;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	public LoanApplication() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LoanApplication(int loanApplicationId, LocalDate loanApplicationDate, Customer customer,
			double loanAppliedAmount, double loanApprovedAmount, boolean landVerificationApproval,
			boolean financeVerificationApproval, boolean adminApproval, Status status) {
		super();
		this.loanApplicationId = loanApplicationId;
		this.loanApplicationDate = loanApplicationDate;
		this.customer = customer;
		this.loanAppliedAmount = loanAppliedAmount;
		this.loanApprovedAmount = loanApprovedAmount;
		this.landVerificationApproval = landVerificationApproval;
		this.financeVerificationApproval = financeVerificationApproval;
		this.adminApproval = adminApproval;
		this.status = status;
	}


	public LoanApplication(LocalDate loanApplicationDate, Customer customer, double loanAppliedAmount,
			double loanApprovedAmount, boolean landVerificationApproval, boolean financeVerificationApproval,
			boolean adminApproval, Status status) {
		super();
		this.loanApplicationDate = loanApplicationDate;
		this.customer = customer;
		this.loanAppliedAmount = loanAppliedAmount;
		this.loanApprovedAmount = loanApprovedAmount;
		this.landVerificationApproval = landVerificationApproval;
		this.financeVerificationApproval = financeVerificationApproval;
		this.adminApproval = adminApproval;
		this.status = status;
	}


	public long getLoanApplicationId() {
		return loanApplicationId;
	}


	public void setLoanApplicationId(int loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}


	public LocalDate getLoanApplicationDate() {
		return loanApplicationDate;
	}


	public void setLoanApplicationDate(LocalDate loanApplicationDate) {
		this.loanApplicationDate = loanApplicationDate;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public double getLoanAppliedAmount() {
		return loanAppliedAmount;
	}


	public void setLoanAppliedAmount(double loanAppliedAmount) {
		this.loanAppliedAmount = loanAppliedAmount;
	}


	public double getLoanApprovedAmount() {
		return loanApprovedAmount;
	}


	public void setLoanApprovedAmount(double loanApprovedAmount) {
		this.loanApprovedAmount = loanApprovedAmount;
	}


	public boolean isLandVerificationApproval() {
		return landVerificationApproval;
	}


	public void setLandVerificationApproval(boolean landVerificationApproval) {
		this.landVerificationApproval = landVerificationApproval;
	}


	public boolean isFinanceVerificationApproval() {
		return financeVerificationApproval;
	}


	public void setFinanceVerificationApproval(boolean financeVerificationApproval) {
		this.financeVerificationApproval = financeVerificationApproval;
	}


	public boolean isAdminApproval() {
		return adminApproval;
	}


	public void setAdminApproval(boolean adminApproval) {
		this.adminApproval = adminApproval;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "LoanApplication [loanApplicationId=" + loanApplicationId + ", loanApplicationDate="
				+ loanApplicationDate + ", customer=" + customer + ", loanAppliedAmount=" + loanAppliedAmount
				+ ", loanApprovedAmount=" + loanApprovedAmount + ", landVerificationApproval="
				+ landVerificationApproval + ", financeVerificationApproval=" + financeVerificationApproval
				+ ", adminApproval=" + adminApproval + ", status=" + status + "]";
	}

	


}
