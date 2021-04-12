package com.cg.homeloan.services;

import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.repositories.ILandVerificationRepository;

public interface ILandVerificationService {
		public void updateStatus(LoanApplication loanApplication);

		}


