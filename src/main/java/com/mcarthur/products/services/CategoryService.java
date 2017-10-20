package com.mcarthur.products.services;

import org.springframework.stereotype.Service;

import com.mcarthur.products.models.Category;
import com.mcarthur.products.repositories.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository catRepo;
	
	public CategoryService(CategoryRepository catRepo) {
		this.catRepo = catRepo;
	}
	
	public void addCategory(Category category) {
		catRepo.save(category);
	}
	
	public Iterable<Category> allCategories(){
		return catRepo.findAll();
	}
	
	public Category findById(Long id) {
		return catRepo.findOne(id);
	}
	
	
	
	
}
