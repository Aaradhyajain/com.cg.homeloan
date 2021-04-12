package com.cg.homeloan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.homeloan.entities.Admin;
import com.cg.homeloan.services.IAdminService;

@RestController
public class AdminController {

	@Autowired
	IAdminService adminService;

	@GetMapping("/Admin")
	public ResponseEntity<List<Admin>> getAdmin() {
		List<Admin> admin = adminService.getAllAdmin();
		return new ResponseEntity<List<Admin>>(admin, HttpStatus.OK);
	}

	@GetMapping("/Admin/{userId}")
	public ResponseEntity<Admin> getAdmin(@PathVariable("userId") int userId) {
		Admin admin = adminService.getAdminId(userId);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	@PostMapping("/Admin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		adminService.addAdmin(admin);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

}
