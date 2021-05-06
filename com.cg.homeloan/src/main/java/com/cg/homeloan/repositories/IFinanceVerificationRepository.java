package com.cg.homeloan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeloan.entities.FinanceVerificationOfficer;

public interface IFinanceVerificationRepository extends JpaRepository<FinanceVerificationOfficer, Integer>{


	public FinanceVerificationOfficer findByUserNameAndPassword(String userName, String password);
}
