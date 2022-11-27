package com.thinhbka.springboot.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinhbka.springboot.model.Latop;
import com.thinhbka.springboot.model.Person;
import com.thinhbka.springboot.repo.PersonRepo;
import com.thinhbka.springboot.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	@Autowired
	PersonService personService;
	
	@Autowired
	Latop l1;
	
	@Autowired
	Latop l2;
	
	@GetMapping("/list")
	public String personList(Model model) {
		List<Person> pList = personService.getAll();
		model.addAttribute("pList", pList);
		return "person/list";
	}
	
	
	@GetMapping("/create")
	public String personCreate(Model model) {
		model.addAttribute("person", new Person());
		return "person/create";
	}
	
	
	@PostMapping("/create")
	public String personCreatePost(@ModelAttribute Person person, Model model) {
		personService.save(person);
		return "redirect:/person/list";
	}
	
	@GetMapping("/search")
	public String personSearch(Model model) {
		Person p = new Person();
		model.addAttribute("person", p);
		return "person/search";
	}
	
	@PostMapping("/search")
	public String personSearchPost(@ModelAttribute Person person ,Model model) {
		String nameLike = person.getName();
		List<Person> pList = personService.searchByName(nameLike);
		System.out.println("search list");
		model.addAttribute("pList", pList);
		return "person/list";
	}
	
	@GetMapping("/detail/{id}")
	public String personDetail(@PathVariable("id") int id,Model model) {
		Person person= personService.findById(id);
		model.addAttribute("person", person);
		return "person/detail";
	}
	
	
	@GetMapping("/edit/{id}")
	public String personEdit(@PathVariable("id") int id,Model model) {
		Person person= personService.findById(id);
		model.addAttribute("person", person);
		return "person/edit";
	}
	@PostMapping("/edit")
	public String personEdit(@ModelAttribute Person person) {
		System.out.println(person);
		personService.save(person);
		return "redirect:/person/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePerson(@PathVariable("id") int id,Model model) {
		personService.removeById(id);
		return "redirect:/person/list";
	}
	
	
	
	
	
}
