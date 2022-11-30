package com.thinhbka.springboot.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thinhbka.springboot.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword%"
			+ " OR p.brand LIKE %:keyword%"
            + " OR p.madein LIKE %:keyword%"
            + " OR CONCAT(p.price, '') LIKE %:keyword%")
	public Page<Product> getProductsWithSearchWord(@Param("keyword") String keyword, Pageable pageable);
	
	
}
