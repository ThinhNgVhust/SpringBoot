package com.example.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "phone")
@Data
@NoArgsConstructor
public class Phone implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "phone_number")
	private String phone_number;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
}
