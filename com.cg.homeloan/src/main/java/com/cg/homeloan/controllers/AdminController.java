package com.cg.homeloan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.homeloan.entities.Admin;
import com.cg.homeloan.services.AdminService;


@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/Admin")
	private List<Admin> getAdmin(){
		return adminService.getAllAdmin();
	}
	
	@GetMapping("/Admin/{userId}")
	private Admin getAdmin(@PathVariable("userId") int userId){
		return adminService.getAdminId(userId) ;
	}
	
	@PostMapping("/Admin")
	private Admin addAdmin(@RequestBody Admin admin) {
		adminService.addAdmin(admin);
		return admin;
	}
	
}
