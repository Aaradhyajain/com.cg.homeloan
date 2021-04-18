package com.cg.homeloan.exceptions;

public class LoanApplicationNotFoundExcption extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoanApplicationNotFoundExcption() {
		super();
	}

	public LoanApplicationNotFoundExcption(String message) {

		super(message);
	}
}
