package com.cg.homeloan.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "emi")

public class EMI {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long EMIId;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dueDate;
	private double emiAmount;
	private double loanAmount;
	private double interestAmount;
	private long loanAgreementId;

	public long getEMIId() {
		return EMIId;
	}

	public void setEMIId(long eMIId) {
		EMIId = eMIId;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(double interestAmount) {
		this.interestAmount = interestAmount;
	}

	public long getLoanAgreementId() {
		return loanAgreementId;
	}

	public void setLoanAgreementId(long loanAgreementId) {
		this.loanAgreementId = loanAgreementId;
	}

	public EMI(long eMIId, LocalDate dueDate, double emiAmount, double loanAmount, double interestAmount,
			long loanAgreementId) {
		super();
		EMIId = eMIId;
		this.dueDate = dueDate;
		this.emiAmount = emiAmount;
		this.loanAmount = loanAmount;
		this.interestAmount = interestAmount;
		this.loanAgreementId = loanAgreementId;
	}

	public EMI() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EMI [EMIId=" + EMIId + ", dueDate=" + dueDate + ", emiAmount=" + emiAmount + ", loanAmount="
				+ loanAmount + ", interestAmount=" + interestAmount + ", loanAgreementId=" + loanAgreementId + "]";
	}

}
