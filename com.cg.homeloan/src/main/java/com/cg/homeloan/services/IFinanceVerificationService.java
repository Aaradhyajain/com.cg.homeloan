package com.cg.homeloan.services;

import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.exceptions.FinanceVerificationException;

public interface IFinanceVerificationService  {
public LoanApplication updateStatus(LoanApplication loanApplication) throws FinanceVerificationException ;

}
