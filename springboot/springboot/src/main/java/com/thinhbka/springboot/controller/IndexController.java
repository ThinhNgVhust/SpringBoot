package com.thinhbka.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.thinhbka.springboot.model.Product;
import com.thinhbka.springboot.service.ProductService;

@Controller
public class IndexController {
	@Autowired
	ProductService productService;
	@GetMapping("/")
	public String index(Model model) {
		return viewPage(model, 1, "name", "asc");
	}
	
	
	@GetMapping("/page/{pageNum}")
	public String viewPage(Model model, 
			@PathVariable(name = "pageNum") int pageNum,
			@Param("sortField") String sortField,
			@Param("sortDir") String sortDir ) {
		
		Page<Product> pageProduct = productService.listAll(pageNum, sortField, sortDir);
		
		List<Product> listProducts = pageProduct.getContent();
		System.out.println(listProducts);
		model.addAttribute("listProducts", listProducts);
		
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("currentPage", pageNum);		
		model.addAttribute("totalPages", pageProduct.getTotalPages());
		model.addAttribute("totalItems", pageProduct.getTotalElements());
		
		return "index";
	}
	
	@GetMapping("/edit/{id}")
	public String showEditProductForm(Model model,@PathVariable(name = "id") Long id) {
		Product product = productService.get(id);
		model.addAttribute("product", product);
		return "edit";
	}	
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.save(product);
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		productService.delete(id);
		
		return "redirect:/";
	}
	
	@GetMapping("/new")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "create.html";
	}
}
