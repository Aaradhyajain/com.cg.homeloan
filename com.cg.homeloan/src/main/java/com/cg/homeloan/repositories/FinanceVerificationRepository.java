package com.cg.homeloan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeloan.entities.FinanceVerificationOfficer;
import com.cg.homeloan.entities.LoanApplication;

public interface FinanceVerificationRepository extends JpaRepository<FinanceVerificationOfficer, Integer>{


}
