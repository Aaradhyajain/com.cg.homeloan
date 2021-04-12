package com.cg.homeloan.utils;

public class EMICalculator {

	private double loanAmount;
	private double rateOfInterest;
	private int tenure;

	public double getEMIAmount() {

		double loanAmount = 1200;  //customer

		double rateOfIntrest = 10;

		double tenure = 1; //customer

		rateOfInterest = rateOfInterest / (12 * 100);

		tenure = tenure * 12;

		double emi = (loanAmount * rateOfInterest * Math.pow(1 + rateOfInterest, tenure))
				/ (Math.pow(1 + rateOfInterest, tenure) - 1);

		return emi;
	};

}
