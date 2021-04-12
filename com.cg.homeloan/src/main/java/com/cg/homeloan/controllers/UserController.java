package com.cg.homeloan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.homeloan.entities.Status;
import com.cg.homeloan.entities.User;
import com.cg.homeloan.repositories.IUserRepository;
import com.cg.homeloan.services.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private IUserRepository iUserRepository;
	
	@PostMapping("/user")    
	public ResponseEntity<User> addNewUser(@RequestBody User newUser)  
	{   
		User user = userService.addNewUser(newUser);
		return new ResponseEntity<User>(user,HttpStatus.OK);    
	}  
	
	@PostMapping("/signin")
	public ResponseEntity<Status> signIn(@RequestParam("username") String username, @RequestParam("password") String password) {
		Status status = userService.signIn(username, password);
		return new ResponseEntity<Status>(status,HttpStatus.OK);
	}
  
	@RequestMapping("/signout")
	public ResponseEntity<Status> signOut(@RequestBody User user) {
		Status status = userService.signOut(user);
		return new ResponseEntity<Status>(status,HttpStatus.OK);
	}
	

}