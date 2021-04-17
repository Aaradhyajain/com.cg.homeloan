package com.cg.homeloan.services;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.homeloan.entities.EMI;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.repositories.IEmiRepository;

public class EmiService implements IEmiService {
	
	
	
	/**
	 * due date calc and set into emi 
	 *  calc amount and set in to emi 
	 *  loan amount hardcore value or generated value by formula
	 */

	@Autowired
	IEmiRepository emiRepository;

	private double loanAmount;
	private double interestAmount;
	private int tenure;
	double emiAmount;

	
	public double calculateEMIAmount() {

		LoanApplication application = new LoanApplication();
		loanAmount = application.getLoanApprovedAmount();
		interestAmount = 10;
		tenure = 1;
		interestAmount = interestAmount / (12 * 100);
		tenure = tenure * 12;
		emiAmount = (loanAmount * interestAmount * Math.pow(1 + interestAmount, tenure))
				/ (Math.pow(1 + interestAmount, tenure) - 1);
		return emiAmount;
	}	 

	@Override
	public EMI addEmiDetails(EMI emi) {
		/**
		 * 
		 */
//		LoanApplication application = new LoanApplication();
//		loanAmount = application.getLoanApprovedAmount();
//		interestAmount = 10;
//		tenure = 1;
//		interestAmount = interestAmount / (12 * 100);
//		tenure = tenure * 12;
//		emiAmount = (loanAmount * interestAmount * Math.pow(1 + interestAmount, tenure))
//				/ (Math.pow(1 + interestAmount, tenure) - 1);
//		
//		LocalDate date = LocalDate.now();
//		emi.setDueDate(date.plusYears(tenure));
//		emi.setEmiAmount(emiAmount);
//		emi.setInterestAmount(interestAmount);
//		emi.setLoanAmount(loanAmount);
		return emiRepository.save(emi);
		

	}

}
