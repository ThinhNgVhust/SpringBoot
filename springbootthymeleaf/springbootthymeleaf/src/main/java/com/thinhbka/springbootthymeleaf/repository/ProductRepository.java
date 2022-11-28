package com.thinhbka.springbootthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinhbka.springbootthymeleaf.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
