package com.cg.homeloan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.entities.User;
import com.cg.homeloan.repositories.IUserRepository;

@Service
public class UserService {

	@Autowired
	private IUserRepository iUserRepository;
	
	public User addNewUser(User newUser)  
	{    
		 return iUserRepository.save(newUser);
	}   
	

	public Status signIn(String username, String password) {
		List<User> users = iUserRepository.findAll();
        for (User other : users) {
            if (other.getUsername().equals(username)&&other.getPassword().equals(password)) {
            	return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
	}
	
	public Status signOut(User user) {
        List<User> users =iUserRepository.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
	
	
}
