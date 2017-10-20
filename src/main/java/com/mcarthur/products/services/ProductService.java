package com.mcarthur.products.services;

import org.springframework.stereotype.Service;
import com.mcarthur.products.repositories.*;
import com.mcarthur.products.models.*;

@Service
public class ProductService {

	private ProductRepository proRepo;
	
	public ProductService(ProductRepository proRepo) {
		this.proRepo = proRepo;
	}
	
	public void addProduct(Product product) {
		proRepo.save(product);
	}
	
	public Product findById(Long id) {
		return proRepo.findOne(id);
	}
	
	public Iterable<Product> allProducts(){
		return proRepo.findAll();
	}
}
