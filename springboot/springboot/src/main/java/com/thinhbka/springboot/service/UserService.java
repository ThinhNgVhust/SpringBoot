package com.thinhbka.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinhbka.springboot.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
}
