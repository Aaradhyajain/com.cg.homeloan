package com.cg.homeloan.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeloan.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}