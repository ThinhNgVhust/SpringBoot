package com.example.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Employee;

public interface EmployeeRepos extends JpaRepository<Employee, Integer>{

}
