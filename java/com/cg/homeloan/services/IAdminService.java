package com.cg.homeloan.services;

import java.util.List;

import com.cg.homeloan.entities.Admin;

public interface IAdminService {

	public Admin addAdmin(Admin admin); 
	public Admin getAdminId(int userId);
	public List<Admin> getAllAdmin();
	//public Admin validateAdmin(Admin admin);
	}

