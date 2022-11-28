package com.thinhbka.springbootthymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thinhbka.springbootthymeleaf.model.Product;
import com.thinhbka.springbootthymeleaf.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository repo;
	
	
	public List<Product> listAll() {
        return repo.findAll();
    }
     
	public Page<Product> listAll(int pageNum) {
	    int pageSize = 5;
	     
	    Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
	     
	    return repo.findAll(pageable);
	}
	
    public void save(Product product) {
        repo.save(product);
    }
     
    public Product get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
