package com.thinhbka.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String intro;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Person(int id,String name, int age,String intro) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.intro = intro;
	}
	
	public Person() {
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+ this.id +" name: " +this.name +" intro:" +this.intro;
	}
}
