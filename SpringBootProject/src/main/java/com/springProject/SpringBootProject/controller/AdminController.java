package com.springProject.SpringBootProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springProject.SpringBootProject.api.Admin;
import com.springProject.SpringBootProject.repository.AdminRepository;

@RestController
public class AdminController {
	
	@Autowired
	AdminRepository ar;
	
	@PostMapping("/saveData")
	public String saveMethod(@RequestBody Admin admin) {
		ar.save(admin);
		return "Save Data Successfully";
	}
	
	@GetMapping("/login")
	public String loginMethod(@RequestBody Admin admin) {
		Admin a = ar.findByEmailAndPassword(admin.getEmail(), admin.getPassword());
		if (a!=null) {
			return "Login Successfully";
		}
		else {
			return "Invalid Credintial";
		}
	}
	
	@GetMapping("/findAgeBetween")
	public List<Admin> findByAgeBetween(@RequestParam int startAge, @RequestParam int endAge) {
		return ar.findByAgeBetween(startAge, endAge);
	}
	
	
	
	
	
}
