package com.cg.homeloan.services;

import com.cg.homeloan.entities.LandVerificationOfficer;

public interface ILandVerificationService {
	
	public Boolean isValidLandOfficer(String userName, String password);
	public LandVerificationOfficer addLandOfficer(LandVerificationOfficer officer); 
}


