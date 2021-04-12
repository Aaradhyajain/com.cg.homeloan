package com.cg.homeloan.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.homeloan.entities.Admin;
import com.cg.homeloan.repositories.AdminRepository;

@Service
public class AdminService implements IAdminService {

	@Autowired
	AdminRepository adminRepository;

	// saving a specific record by using the method save() of CrudRepository
	public Admin addAdmin(Admin admin) {
		adminRepository.save(admin);
		return admin;
	}

	// getting a specific record by using the method findById() of CrudRepository
	public Admin getAdminId(int userId) {
		return adminRepository.findById(userId).get();
	}

	// getting all Employee record by using the method findaAll() of CrudRepository
	public List<Admin> getAllAdmin() {
		List<Admin> admin = new ArrayList<Admin>();
		admin = adminRepository.findAll();
		return admin;
	}
}
