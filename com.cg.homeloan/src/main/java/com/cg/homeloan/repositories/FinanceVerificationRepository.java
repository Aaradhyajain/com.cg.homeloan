package com.cg.homeloan.repositories;

import com.cg.homeloan.entities.LoanApplication;

public interface FinanceVerificationRepository {
public void updateStatus(LoanApplication loanApplication);

}
