package com.thinhbka.springbootthymeleaf.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.thinhbka.springbootthymeleaf.model.User;

@Controller
public class MainController {
	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("listProfession", listProfession);
		return "register.html";
	}
	
	@PostMapping("/register")
	public String doRegistration(@ModelAttribute User user, Model model) {
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(user.getBirthday());
		model.addAttribute("user", user);
		return "register_success.html";
	}
}
