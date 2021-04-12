package com.cg.homeloan.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.homeloan.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer>{
	

//	public Status addNewUser(User user);
//
//	public Status signIn(User user);
//
//	public Status signOut(User user);

}
