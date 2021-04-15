package com.cg.homeloan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeloan.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer>{
//	public  User addNewUser(User user);
//	public User signIn(User user);
//	public User signOut(User user);
}
