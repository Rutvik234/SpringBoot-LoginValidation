package com.springProject.SpringBootProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springProject.SpringBootProject.api.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	Admin findByEmailAndPassword(String email, String password);
	
	List<Admin> findByAgeBetween(int startage, int endage);
}
