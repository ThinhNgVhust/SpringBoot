package com.thinhbka.springbootthymeleaf.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.thinhbka.springbootthymeleaf.model.Product;
import com.thinhbka.springbootthymeleaf.model.User;
import com.thinhbka.springbootthymeleaf.service.ProductService;

@Controller
public class MainController {
	@Autowired
	ProductService productService;
	@GetMapping("/")
	public String index(Model model) {
		List<Product>listProducts = productService.listAll();
		model.addAttribute("listProducts", listProducts);
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
	
	
	
	@GetMapping("/new")
	public String showNewProductPage(Model model) {
	    Product product = new Product();
	    model.addAttribute("product", product);
	     
	    return "new_product";
	}
	@PostMapping("/save")
	public String doSaveProduct(@ModelAttribute Product product ,Model model) {
		System.out.println("new model");
	    productService.save(product);
	    return "redirect:/";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Product product = productService.get(id);
		model.addAttribute("product", product);
		return "edit_product";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    productService.delete(id);
	    return "redirect:/";       
	}
}
