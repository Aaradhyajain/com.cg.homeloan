package com.cg.homeloan.repositories;

import com.cg.homeloan.entities.User;

public interface IUserRepository {
public  User addNewUser(User user);
public User signIn(User user);
public User signOut(User user);
}
