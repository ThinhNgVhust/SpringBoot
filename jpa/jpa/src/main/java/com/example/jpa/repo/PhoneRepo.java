package com.example.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Phone;

public interface PhoneRepo extends JpaRepository<Phone, Integer>{

}
