package com.thinhbka.springboot.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.thinhbka.springboot.model.User;
import com.thinhbka.springboot.repo.UserRepository;
import com.thinhbka.springboot.service.UserService;
import com.thinhbka.springboot.util.FileUploadUtil;

@Controller
public class HomeController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
	public String index() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "auth/register.html";
	}
	
	@PostMapping("/register")
	public String doRegister(Model model,
			@ModelAttribute("user") User user,
			@RequestParam("image") MultipartFile multipartFile) {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		System.out.println("file name:" + fileName);
		User u = userRepository.findByEmail(user.getEmail());
		if(u!=null) {
			model.addAttribute("errorEmail", "Email exist in database, please change another email");
			return "auth/register.html";
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPhoto(fileName);
	    user.setPassword(encodedPassword);
		userRepository.save(user);
		String uploadDir = "user-photos/" + user.getId();//can custom change dir
		try {
			FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("user",user);
		return "auth/register_success.html";
	}
	
	@GetMapping("/login")
	public String login(Model model) {	
		User u = new User();
		model.addAttribute("user",u);
		return "auth/login.html";
	}
	
	@PostMapping("/login")
	public String doLogin() {
		return "";
	}
}
