package com.cg.homeloan.repositories;

import com.cg.homeloan.entities.LoanApplication;

public interface IFinanceVerificationRepository {
public void updateStatus(LoanApplication loanApplication);

}
