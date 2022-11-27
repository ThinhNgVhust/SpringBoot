package com.thinhbka.springboot.service;
import com.thinhbka.springboot.model.Person;

import java.util.List;	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinhbka.springboot.repo.PersonRepo;

@Service
public class PersonService {
	@Autowired
	PersonRepo personRepo;
	
	
	public List<Person>getAll(){
		return personRepo.findAll();
	}
	
	public void save(Person person) {
		personRepo.save(person);
	}
	
	public Person findById(int id) {
		return personRepo.findById(id).get();
	}
	
	public void removeById(int id) {
		personRepo.deleteById(id);
	}
	
	public List<Person>searchByName(String nameLike){
		return personRepo.findByName(nameLike);
	}
	
}
