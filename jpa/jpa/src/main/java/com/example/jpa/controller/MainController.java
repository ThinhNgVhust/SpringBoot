package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Employee;
import com.example.jpa.entity.Phone;
import com.example.jpa.repo.EmployeeRepos;
import com.example.jpa.repo.PhoneRepo;

@RestController
public class MainController {
	@Autowired
	PhoneRepo phoneRepo;
	@Autowired
	EmployeeRepos employeeRepo;
	
	
	@GetMapping("/gete/{id}")
	public Employee list(@PathVariable int id) {
	    return employeeRepo.findById(id).orElse(null);
	}
	@GetMapping("/getp/{id}")
	public Phone getPhone(@PathVariable int id) {
	    return phoneRepo.findById(id).orElse(null);
	}
	@GetMapping("/getallp")
	public List<Phone> getAllPhone() {
	    return phoneRepo.findAll();
	}
	
	@GetMapping("/getalle")
	public List<Employee> getAllE() {
	    return employeeRepo.findAll();
	}
}
