package com.cg.homeloan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeloan.entities.LoanAgreement;
//import com.cg.homeloan.entities.LoanApplication;

public interface ILoanAgreementRepository extends JpaRepository<LoanAgreement, Long> {
	
}
