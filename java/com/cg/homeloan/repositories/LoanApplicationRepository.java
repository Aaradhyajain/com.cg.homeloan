package com.cg.homeloan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeloan.entities.LoanApplication;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Integer> {

}