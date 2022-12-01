package com.thinhbka.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.thinhbka.springboot.model.Product;
import com.thinhbka.springboot.repo.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;

	public Page<Product> listAll(int pageNum, String sortField, String sortDir,String keySearch) {
		Pageable pageable = PageRequest.of(pageNum-1, 5,
				sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
		if(keySearch!=null && keySearch.equals("")==false) {
			return repo.getProductsWithSearchWord(keySearch, pageable);
		}
		
		return repo.findAll(pageable);
	}
	public void save(Product product) {
		repo.save(product);
	}
	public Product get(Long id) {
		return repo.findById(id).orElse(null);
	}
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
