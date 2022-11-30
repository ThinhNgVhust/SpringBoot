package com.thinhbka.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.thinhbka.authentication.model.User;
import com.thinhbka.authentication.repository.UserRepository;

@Controller
public class HomeController {
	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("/")
	public String viewHomePage() {
		System.out.println("go here");
        return "index.html";
    }
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	     
	    return "signup_form";
	}
	
//	@PostMapping("/process_register")
//	public String processRegister(User user) {
//	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	    String encodedPassword = passwordEncoder.encode(user.getPassword());
//	    user.setPassword(encodedPassword);
//	     
//	    userRepo.save(user);
//	     
//	    return "register_success";
//	}
	
}
