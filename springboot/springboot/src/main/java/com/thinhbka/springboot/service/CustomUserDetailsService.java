package com.thinhbka.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.thinhbka.springboot.model.CustomUserDetails;
import com.thinhbka.springboot.model.User;
import com.thinhbka.springboot.repo.UserRepository;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = repository.findByEmail(email);
		 if (user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        return new CustomUserDetails(user);
	}

}
