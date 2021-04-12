package com.cg.homeloan.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LoanAgreement")
public class LoanAgreement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long loanAgreementId;
	private long loanApplicationId;
	@OneToOne(cascade = CascadeType.ALL)
	private EMI emi;

	public long getLoanAgreementId() {
		return loanAgreementId;
	}

	public void setLoanAgreementId(long loanAgreementId) {
		this.loanAgreementId = loanAgreementId;
	}

	public long getLoanApplicationId() {
		return loanApplicationId;
	}

	public void setLoanApplicationId(long loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}

	public EMI getEmi() {
		return emi;
	}

	public void setEmi(EMI emi) {
		this.emi = emi;
	}

	public LoanAgreement(long loanAgreementId, long loanApplicationId, EMI emi) {
		super();
		this.loanAgreementId = loanAgreementId;
		this.loanApplicationId = loanApplicationId;
		this.emi = emi;
	}

	public LoanAgreement() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LoanAgreement [loanAgreementId=" + loanAgreementId + ", loanApplicationId=" + loanApplicationId
				+ ", emi=" + emi + "]";
	}

}
