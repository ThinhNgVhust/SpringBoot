package com.thinhbka.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinhbka.springboot.model.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{
	List<Person> findByName(String name);
}
